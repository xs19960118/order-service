package com.xs.order.service.infrastructure.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * 方法名约定自动读写分离: 以 get/find/list/query/page/count/select 开头走从库.
 * 优先级低于显式 @ReadOnly (显式注解已设置则不再覆盖)
 */
@Aspect
@Component
@Order(200) // 比显式注解切面晚执行, 不覆盖
public class MethodNameReadOnlyAspect {

    private static final Set<String> READ_PREFIX = Set.of(
            "get", "find", "list", "query", "page", "count", "select"
    );

    @Around("execution(* com.xs..*.*(..))")
    public Object autoRead(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        String name = method.getName();
        boolean explicit = DataSourceContextHolder.getRole() == DataSourceRole.SLAVE; // 已被 @ReadOnly 标记
        boolean picked = false;
        if (!explicit) {
            for (String prefix : READ_PREFIX) {
                if (name.startsWith(prefix)) {
                    DataSourceContextHolder.useSlave();
                    picked = true;
                    break;
                }
            }
        }
        try {
            return pjp.proceed();
        } finally {
            if (picked) {
                DataSourceContextHolder.clear();
            }
        }
    }
}

