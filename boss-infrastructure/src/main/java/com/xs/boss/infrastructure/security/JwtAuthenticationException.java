package com.xs.boss.infrastructure.security;

/**
 * JWT 认证异常
 *
 * @author xiangshang
 */
public class JwtAuthenticationException extends RuntimeException {

    public JwtAuthenticationException(String message) {
        super(message);
    }

    public JwtAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

