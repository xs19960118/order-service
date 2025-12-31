package com.xs.boss.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xs.boss.domain.user.model.CurrentUser;
import com.xs.boss.infrastructure.annotation.JWT;
import com.xs.boss.infrastructure.annotation.SkipJWT;
import com.xs.boss.infrastructure.config.JwtConfig;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;
import java.util.Optional;

/**
 * JWT 认证拦截器
 * 基础设施层 - 只对带有 @JWT 注解的接口进行 JWT Token 验证，并将用户信息放入上下文
 * <p>
 * 使用 JDK 17 特性优化：
 * - Pattern matching for instanceof
 * - var 关键字简化变量声明
 * - Optional 链式调用优化 null 处理
 * - 方法提取提高可读性
 *
 * @author xiangshang
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthInterceptor implements HandlerInterceptor {

    private static final String USER_KEY_PREFIX = "boss_user:";
    private static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtConfig jwtConfig;
    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        // 1. 检查是否为 HandlerMethod（使用 pattern matching）
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }

        // 2. 优先检查 @SkipJWT 注解（优先级高于 @JWT）
        var skipJwtAnnotation = findSkipJwtAnnotation(handlerMethod);
        if (skipJwtAnnotation.isPresent()) {
            var skipReason = skipJwtAnnotation.get().value();
            log.debug("接口标记 @SkipJWT，跳过认证: {} {}", request.getRequestURI(), 
                    skipReason.isEmpty() ? "" : "(" + skipReason + ")");
            return true;
        }

        // 3. 查找 @JWT 注解（方法优先，类次之）
        var jwtAnnotation = findJwtAnnotation(handlerMethod);
        if (jwtAnnotation.isEmpty()) {
            log.debug("接口未标记 @JWT 注解，跳过认证: {}", request.getRequestURI());
            return true;
        }

        var annotation = jwtAnnotation.get();
        var required = annotation.required();

        // 4. 提取 Token
        var token = extractToken(request);
        if (token.isEmpty()) {
            return handleMissingToken(request, response, required);
        }

        // 5. 验证并处理 Token
        return validateAndProcessToken(request, response, token.get(), required);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 清除上下文，避免内存泄漏
        SecurityContextHolder.clear();
    }

    /**
     * 查找 @SkipJWT 注解（方法优先，类次之）
     */
    private Optional<SkipJWT> findSkipJwtAnnotation(HandlerMethod handlerMethod) {
        var methodAnnotation = Optional.ofNullable(handlerMethod.getMethodAnnotation(SkipJWT.class));
        return methodAnnotation.or(() -> Optional.ofNullable(handlerMethod.getBeanType().getAnnotation(SkipJWT.class)));
    }

    /**
     * 查找 @JWT 注解（方法优先，类次之）
     */
    private Optional<JWT> findJwtAnnotation(HandlerMethod handlerMethod) {
        var methodAnnotation = Optional.ofNullable(handlerMethod.getMethodAnnotation(JWT.class));
        return methodAnnotation.or(() -> Optional.ofNullable(handlerMethod.getBeanType().getAnnotation(JWT.class)));
    }

    /**
     * 从请求头提取 Token
     */
    private Optional<String> extractToken(HttpServletRequest request) {
        var bearerToken = request.getHeader(jwtConfig.getHeader());
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtConfig.getPrefix())) {
            return Optional.of(bearerToken.substring(jwtConfig.getPrefix().length()));
        }
        return Optional.empty();
    }

    /**
     * 处理缺失 Token 的情况
     */
    private boolean handleMissingToken(HttpServletRequest request, HttpServletResponse response, boolean required) throws Exception {
        if (!required) {
            log.debug("接口标记 @JWT(required=false)，未提供 Token，直接放行: {}", request.getRequestURI());
            return true;
        }
        log.warn("请求未携带 Token, URI: {}", request.getRequestURI());
        return unauthorizedResponse(response, "未提供认证Token");
    }

    /**
     * 验证并处理 Token
     */
    private boolean validateAndProcessToken(HttpServletRequest request, HttpServletResponse response, String token, boolean required) throws Exception {
        try {
            // 验证 Token
            if (!jwtTokenProvider.validateToken(token)) {
                return handleValidationFailure(request, response, required, "Token 验证失败");
            }

            // 解析 Token 获取用户ID
            var userId = jwtTokenProvider.getUserIdFromToken(token);
            log.debug("Token 验证成功, 用户ID: {}", userId);

            // 加载用户信息并设置到上下文
            var currentUser = loadUserFromRedis(userId, token)
                    .orElseGet(() -> CurrentUser.builder().userId(userId).build());

            SecurityContextHolder.setCurrentUser(currentUser);
            log.debug("用户认证成功: userId={}, username={}", currentUser.getUserId(), currentUser.getUsername());
            return true;

        } catch (JwtAuthenticationException e) {
            return handleAuthenticationException(request, response, required, e.getMessage());
        } catch (Exception e) {
            return handleGeneralException(request, response, required, e);
        }
    }

    /**
     * 处理验证失败
     */
    private boolean handleValidationFailure(HttpServletRequest request, HttpServletResponse response, boolean required, String message) throws Exception {
        if (!required) {
            log.debug("接口标记 @JWT(required=false)，{}, 直接放行: {}", message, request.getRequestURI());
            return true;
        }
        return unauthorizedResponse(response, message);
    }

    /**
     * 处理认证异常
     */
    private boolean handleAuthenticationException(HttpServletRequest request, HttpServletResponse response, boolean required, String message) throws Exception {
        if (!required) {
            log.debug("接口标记 @JWT(required=false)，认证异常，直接放行: {}", message);
            return true;
        }
        log.warn("JWT 认证失败: {}", message);
        return unauthorizedResponse(response, message);
    }

    /**
     * 处理通用异常
     */
    private boolean handleGeneralException(HttpServletRequest request, HttpServletResponse response, boolean required, Exception e) throws Exception {
        if (!required) {
            log.debug("接口标记 @JWT(required=false)，认证异常，直接放行: {}", e.getMessage());
            return true;
        }
        log.error("JWT 认证异常", e);
        return unauthorizedResponse(response, "认证系统异常");
    }

    /**
     * 从 Redis 加载用户信息
     * <p>
     * 优先从 Redis 加载，如果不存在则从 Token Claims 中构建
     */
    private Optional<CurrentUser> loadUserFromRedis(Long userId, String token) {
        try {
            // 方案1: 从 Redis 加载完整用户信息
            var userKey = USER_KEY_PREFIX + userId;
            var userJson = stringRedisTemplate.opsForValue().get(userKey);

            if (StringUtils.hasText(userJson)) {
                return Optional.of(objectMapper.readValue(userJson, CurrentUser.class));
            }

            // 方案2: 从 Token 的 Claims 中获取用户信息
            var claims = jwtTokenProvider.parseToken(token);
            var user = CurrentUser.builder()
                    .userId(userId)
                    .username(getClaimValue(claims, "username"))
                    .realName(getClaimValue(claims, "realName"))
                    .mobile(getClaimValue(claims, "mobile"))
                    .email(getClaimValue(claims, "email"))
                    .role(getClaimValue(claims, "role"))
                    .build();

            return Optional.of(user);

        } catch (Exception e) {
            log.warn("从 Redis 加载用户信息失败: userId={}, error={}", userId, e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * 安全获取 Claim 值
     */
    private String getClaimValue(Claims claims, String key) {
        return Optional.ofNullable(claims.get(key, String.class)).orElse("");
    }

    /**
     * 返回未授权响应
     */
    private boolean unauthorizedResponse(HttpServletResponse response, String message) throws Exception {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(JSON_CONTENT_TYPE);

        var result = HttpResponseEntity.fail(401, message);
        var writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(result));
        writer.flush();
        return false;
    }
}

