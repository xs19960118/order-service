package com.xs.boss.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xs.boss.domain.user.model.CurrentUser;
import com.xs.boss.infrastructure.config.JwtConfig;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

/**
 * JWT 认证拦截器
 * 基础设施层 - 拦截所有请求，验证 JWT Token，并将用户信息放入上下文
 *
 * @author xiangshang
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtConfig jwtConfig;
    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 从请求头获取 Token
        String token = extractToken(request);

        if (!StringUtils.hasText(token)) {
            log.warn("请求未携带 Token, URI: {}", request.getRequestURI());
            return unauthorizedResponse(response, "未提供认证Token");
        }

        try {
            // 2. 验证 Token
            if (!jwtTokenProvider.validateToken(token)) {
                return unauthorizedResponse(response, "Token 验证失败");
            }

            // 3. 解析 Token 获取用户ID
            Long userId = jwtTokenProvider.getUserIdFromToken(token);
            log.debug("Token 验证成功, 用户ID: {}", userId);

            // 4. 从 Redis 加载用户信息（可选，看你们业务需要）
            CurrentUser currentUser = loadUserFromRedis(userId, token);

            if (currentUser == null) {
                // 如果 Redis 中没有，可以简单构造一个（或者查数据库）
                currentUser = CurrentUser.builder()
                        .userId(userId)
                        .build();
            }

            // 5. 将用户信息放入上下文
            SecurityContextHolder.setCurrentUser(currentUser);

            log.debug("用户认证成功: userId={}, username={}", currentUser.getUserId(), currentUser.getUsername());
            return true;

        } catch (JwtAuthenticationException e) {
            log.warn("JWT 认证失败: {}", e.getMessage());
            return unauthorizedResponse(response, e.getMessage());
        } catch (Exception e) {
            log.error("JWT 认证异常", e);
            return unauthorizedResponse(response, "认证系统异常");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 清除上下文，避免内存泄漏
        SecurityContextHolder.clear();
    }

    /**
     * 从请求头提取 Token
     */
    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtConfig.getHeader());
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtConfig.getPrefix())) {
            return bearerToken.substring(jwtConfig.getPrefix().length());
        }
        return null;
    }

    /**
     * 从 Redis 加载用户信息
     * 你们PHP可能把用户信息缓存在 Redis 中，格式可能是: user:{userId}
     */
    private CurrentUser loadUserFromRedis(Long userId, String token) {
        try {
            // 方案1: 从 Redis 加载完整用户信息（假设key格式为: boss_user:{userId}）
            String userKey = "boss_user:" + userId;
            String userJson = stringRedisTemplate.opsForValue().get(userKey);
            
            if (StringUtils.hasText(userJson)) {
                return objectMapper.readValue(userJson, CurrentUser.class);
            }

            // 方案2: 从 Token 的 Claims 中获取用户信息（如果生成Token时放进去了）
            Claims claims = jwtTokenProvider.parseToken(token);
            return CurrentUser.builder()
                    .userId(userId)
                    .username(claims.get("username", String.class))
                    .realName(claims.get("realName", String.class))
                    .mobile(claims.get("mobile", String.class))
                    .email(claims.get("email", String.class))
                    .role(claims.get("role", String.class))
                    .build();

        } catch (Exception e) {
            log.warn("从 Redis 加载用户信息失败: userId={}, error={}", userId, e.getMessage());
            return null;
        }
    }

    /**
     * 返回未授权响应
     */
    private boolean unauthorizedResponse(HttpServletResponse response, String message) throws Exception {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        
        HttpResponseEntity<Void> result = HttpResponseEntity.fail(401, message);
        
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(result));
        writer.flush();
        
        return false;
    }
}

