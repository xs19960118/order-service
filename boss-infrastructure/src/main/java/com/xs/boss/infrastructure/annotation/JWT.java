package com.xs.boss.infrastructure.annotation;

import java.lang.annotation.*;

/**
 * JWT 认证注解
 * 标记在 Controller 方法或类上，表示该接口需要 JWT Token 认证
 * <p>
 * 使用示例：
 * <pre>
 * {@code
 * @JWT
 * @PostMapping("/api/orders")
 * public HttpResponseEntity<OrderVO> createOrder(@RequestBody OrderCreateCmd cmd) {
 *     // 需要认证的接口
 * }
 * }
 * </pre>
 *
 * @author xiangshang
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JWT {

    /**
     * 是否必须认证（默认 true）
     * 设置为 false 时，即使没有 Token 也会放行（但会尝试解析 Token 获取用户信息）
     */
    boolean required() default true;

    /**
     * 描述信息（可选，用于文档说明）
     */
    String value() default "";
}

