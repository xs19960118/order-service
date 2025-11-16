package com.xs.order.service.infrastructure.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadOnlyAspect {
    @Around("@annotation(ReadOnly)")
    public Object useSlave(ProceedingJoinPoint pjp) throws Throwable {
        try {
            DataSourceContextHolder.useSlave();
            return pjp.proceed();
        } finally {
            DataSourceContextHolder.clear();
        }
    }
}
