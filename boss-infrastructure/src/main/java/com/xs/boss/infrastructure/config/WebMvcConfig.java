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
 * <p>
 * 注意：拦截器采用基于注解的方式，只对标记了 @JWT 注解的接口进行认证
 * 使用方式：在 Controller 方法或类上添加 @JWT 注解即可
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
        log.info("注册 JWT 认证拦截器（基于 @JWT 注解）");

        registry.addInterceptor(jwtAuthInterceptor)
                // 拦截所有 API 接口（拦截器内部会判断是否有 @JWT 注解）
                .addPathPatterns("/api/**")
                
                // 排除以下路径（这些路径不会被拦截器处理）
                .excludePathPatterns(
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

        log.info("JWT 认证拦截器注册完成 - 使用方式：在需要认证的接口上添加 @JWT 注解");
    }
}

