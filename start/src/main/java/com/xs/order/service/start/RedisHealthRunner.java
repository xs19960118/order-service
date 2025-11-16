package com.xs.order.service.start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisHealthRunner implements CommandLineRunner {

    private final StringRedisTemplate redisTemplate;

    public RedisHealthRunner(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run(String... args) {
        try {
            String key = "health:ping";
            redisTemplate.opsForValue().set(key, "pong", java.time.Duration.ofSeconds(30));
            String val = redisTemplate.opsForValue().get(key);
            System.out.println("Redis cluster ping result = " + val);
        } catch (Exception e) {
            System.err.println("Redis cluster ping failed: " + e.getMessage());
        }
    }
}

