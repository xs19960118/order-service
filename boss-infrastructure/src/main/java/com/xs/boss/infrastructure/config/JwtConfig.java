package com.xs.boss.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * JWT 配置类
 * 基础设施层 - 统一管理JWT相关配置
 * 
 * @author xiangshang
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    /**
     * JWT 密钥
     */
    private String secret;

    /**
     * JWT 算法
     */
    private String algo = "HS256";

    /**
     * JWT 过期时间（秒）
     */
    private Long expire;

    /**
     * Token 请求头名称
     */
    private String header = "Authorization";

    /**
     * Token 前缀
     */
    private String prefix = "Bearer ";
}

