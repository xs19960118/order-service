package com.xs.boss.infrastructure.security;

import com.xs.boss.infrastructure.config.JwtConfig;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * JWT Token 工具类
 * 基础设施层 - 负责 Token 的生成、解析、验证
 *
 * @author xiangshang
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final long ONE_HOUR_MILLIS = 3600000L;

    private final JwtConfig jwtConfig;

    /**
     * 生成 JWT Token
     * <p>
     * 使用 JDK 17 特性优化：var 关键字、Optional 处理 null
     *
     * @param userId  用户ID
     * @param payload 额外负载数据
     * @return JWT Token
     */
    public String generateToken(Long userId, Map<String, Object> payload) {
        var now = new Date();
        var expiryDate = new Date(now.getTime() + jwtConfig.getExpire() * 1000L);

        var builder = Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256);

        // 添加自定义 Payload（使用 Optional 处理 null）
        Optional.ofNullable(payload)
                .filter(p -> !p.isEmpty())
                .ifPresent(builder::addClaims);

        return builder.compact();
    }

    /**
     * 从 Token 中解析用户ID
     *
     * @param token JWT Token
     * @return 用户ID
     */
    public Long getUserIdFromToken(String token) {
        var claims = parseToken(token);
        return Long.parseLong(claims.getSubject());
    }

    /**
     * 从 Token 中获取所有 Claims
     * <p>
     * 使用 JDK 17 的异常处理优化，统一处理 JWT 相关异常
     *
     * @param token JWT Token
     * @return Claims
     */
    public Claims parseToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            log.warn("JWT Token 已过期: {}", e.getMessage());
            throw new JwtAuthenticationException("Token 已过期", e);
        } catch (UnsupportedJwtException | MalformedJwtException e) {
            // 合并处理格式相关异常
            var message = e instanceof UnsupportedJwtException ? "不支持的 Token 格式" : "Token 格式错误";
            log.warn("JWT Token 格式异常: {}", e.getMessage());
            throw new JwtAuthenticationException(message, e);
        } catch (SignatureException e) {
            log.warn("JWT Token 签名验证失败: {}", e.getMessage());
            throw new JwtAuthenticationException("Token 签名验证失败", e);
        } catch (IllegalArgumentException e) {
            log.warn("JWT Token 为空: {}", e.getMessage());
            throw new JwtAuthenticationException("Token 不能为空", e);
        }
    }

    /**
     * 验证 Token 是否有效
     *
     * @param token JWT Token
     * @return 是否有效
     */
    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtAuthenticationException e) {
            return false;
        }
    }

    /**
     * 从 Token 中获取过期时间
     *
     * @param token JWT Token
     * @return 过期时间
     */
    public Date getExpirationFromToken(String token) {
        var claims = parseToken(token);
        return claims.getExpiration();
    }

    /**
     * 判断 Token 是否即将过期（1小时内）
     *
     * @param token JWT Token
     * @return 是否即将过期
     */
    public boolean isTokenExpiringSoon(String token) {
        var expiration = getExpirationFromToken(token);
        var diff = expiration.getTime() - System.currentTimeMillis();
        return diff < ONE_HOUR_MILLIS;
    }

    /**
     * 获取签名密钥
     */
    private SecretKey getSigningKey() {
        var keyBytes = jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

