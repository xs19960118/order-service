package com.xs.boss.infrastructure.config;

import com.xs.boss.infrastructure.security.JwtAuthInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 配置
 * 配置 JWT 认证拦截器
 *
 * @author xiangshang
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final JwtAuthInterceptor jwtAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册 JWT 认证拦截器");

        registry.addInterceptor(jwtAuthInterceptor)
                // 拦截所有 API 接口
                .addPathPatterns("/api/**")
                
                // 排除以下路径（不需要认证）
                .excludePathPatterns(
                        // 登录、注册等公开接口
                        "/api/v1/auth/login",
                        "/api/v1/auth/register",
                        "/api/v1/auth/captcha",
                        "/api/v1/auth/forgot-password",
                        
                        // 测试接口（开发环境可能需要）
                        "/test/**",
                        
                        // Swagger/Knife4j 文档
                        "/doc.html",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-resources/**",
                        "/webjars/**",
                        
                        // 健康检查
                        "/actuator/**",
                        
                        // 静态资源
                        "/static/**",
                        "/favicon.ico"
                );

        log.info("JWT 认证拦截器注册完成");
    }
}

