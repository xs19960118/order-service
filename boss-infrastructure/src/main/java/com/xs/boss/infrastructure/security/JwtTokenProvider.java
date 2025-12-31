package com.xs.boss.infrastructure.security;

import com.xs.boss.infrastructure.config.JwtConfig;
import com.xs.boss.infrastructure.enums.ErrorCodeEnum;
import com.xs.boss.infrastructure.exception.BossBusinessException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
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
public class JwtTokenProvider {

    /**
     * 1小时对应的毫秒数
     */
    private static final long ONE_HOUR_MILLIS = 3600000L;

    @Resource
    private JwtConfig jwtConfig;

    /**
     * 生成 Token
     *
     * @param payload jwt.payload
     * @return token
     */
    public String generateToken(Map<String, Object> payload) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtConfig.getExpire() * 1000L);

        JwtBuilder builder = Jwts.builder()
                .subject(payload.get("username").toString())
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey());

        Optional.of(payload)
                .filter(p -> !p.isEmpty())
                .ifPresent(builder::claims);

        return builder.compact();
    }

    /**
     * 从 Token 中解析用户名
     *
     * @param token JWT Token
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 从 Token 中获取所有 Claims
     * <p>
     * 使用 JDK 17 的 pattern matching for instanceof 优化异常处理，统一包装为 BossBusinessException
     *
     * @param token JWT Token
     * @return Claims
     */
    public Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {
            BossBusinessException exception = convertToBossBusinessException(e);
            log.warn("JWT Token 解析异常: {}", exception.getMessage());
            throw exception;
        }
    }

    /**
     * 将异常转换为 BossBusinessException
     *
     * @param e 异常
     * @return BossBusinessException
     */
    private BossBusinessException convertToBossBusinessException(Exception e) {
        if (e instanceof ExpiredJwtException expiredJwtException) {
            return new BossBusinessException(ErrorCodeEnum.TOKEN_EXPIRED, expiredJwtException);
        } else if (e instanceof UnsupportedJwtException unsupportedJwtException) {
            return new BossBusinessException(ErrorCodeEnum.TOKEN_UNSUPPORTED, unsupportedJwtException);
        } else if (e instanceof MalformedJwtException malformedJwtException) {
            return new BossBusinessException(ErrorCodeEnum.TOKEN_MALFORMED, malformedJwtException);
        } else if (e instanceof JwtException jwtException) {
            return new BossBusinessException(ErrorCodeEnum.TOKEN_SIGNATURE_INVALID, jwtException);
        } else if (e instanceof IllegalArgumentException illegalArgumentException) {
            return new BossBusinessException(ErrorCodeEnum.TOKEN_EMPTY, illegalArgumentException);
        } else {
            return new BossBusinessException(ErrorCodeEnum.TOKEN_PARSE_ERR, e);
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
        } catch (BossBusinessException e) {
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
        return diff < ONE_HOUR_MILLIS;
    }

    /**
     * 获取签名密钥
     */
    private SecretKey getSigningKey() {
        byte[] keyBytes = jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

