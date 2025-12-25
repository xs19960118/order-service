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

    private final JwtConfig jwtConfig;

    /**
     * 生成 JWT Token
     *
     * @param userId  用户ID
     * @param payload 额外负载数据
     * @return JWT Token
     */
    public String generateToken(Long userId, Map<String, Object> payload) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtConfig.getExpire() * 1000);

        JwtBuilder builder = Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256);

        // 添加自定义 Payload
        if (payload != null && !payload.isEmpty()) {
            builder.addClaims(payload);
        }

        return builder.compact();
    }

    /**
     * 从 Token 中解析用户ID
     *
     * @param token JWT Token
     * @return 用户ID
     */
    public Long getUserIdFromToken(String token) {
        Claims claims = parseToken(token);
        return Long.parseLong(claims.getSubject());
    }

    /**
     * 从 Token 中获取所有 Claims
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
        } catch (UnsupportedJwtException e) {
            log.warn("不支持的 JWT Token: {}", e.getMessage());
            throw new JwtAuthenticationException("不支持的 Token 格式", e);
        } catch (MalformedJwtException e) {
            log.warn("JWT Token 格式错误: {}", e.getMessage());
            throw new JwtAuthenticationException("Token 格式错误", e);
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
        Claims claims = parseToken(token);
        return claims.getExpiration();
    }

    /**
     * 判断 Token 是否即将过期（1小时内）
     *
     * @param token JWT Token
     * @return 是否即将过期
     */
    public boolean isTokenExpiringSoon(String token) {
        Date expiration = getExpirationFromToken(token);
        long diff = expiration.getTime() - System.currentTimeMillis();
        return diff < 3600000; // 1小时
    }

    /**
     * 获取签名密钥
     */
    private SecretKey getSigningKey() {
        byte[] keyBytes = jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

