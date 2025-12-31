package com.xs.boss.infrastructure.annotation;

import java.lang.annotation.*;

/**
 * 跳过 JWT 认证注解
 * <p>
 * 标记在 Controller 方法或类上，表示该接口不需要 JWT Token 认证
 * <p>
 * 优先级：@SkipJWT > @JWT
 * - 如果类上标记了 @JWT，但某个方法标记了 @SkipJWT，则该方法不需要认证
 * - 如果方法上同时标记了 @JWT 和 @SkipJWT，@SkipJWT 优先级更高
 * <p>
 * 使用场景：
 * - 类上标记了 @JWT，但某些公开方法（如登录、注册）不需要认证
 * - 明确表示某个接口跳过认证（作为文档说明）
 *
 * @author xiangshang
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SkipJWT {
    
    /**
     * 跳过原因（可选，用于文档说明）
     */
    String value() default "";
}

