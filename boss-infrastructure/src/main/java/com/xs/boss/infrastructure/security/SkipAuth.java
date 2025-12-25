package com.xs.boss.infrastructure.security;

import java.lang.annotation.*;

/**
 * 跳过 JWT 认证注解
 * 标记在 Controller 方法上，表示该接口不需要认证
 *
 * @author xiangshang
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SkipAuth {
    
    /**
     * 跳过原因（可选，用于文档说明）
     */
    String value() default "";
}

