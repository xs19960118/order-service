package com.xs.order.service.start;

import com.xs.order.service.infrastructure.persistence.mapper.OrderMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InfraHealthController {

    private final OrderMapper orderMapper;
    private final StringRedisTemplate redisTemplate;
    private final KafkaTemplate<String,String> kafkaTemplate;

    public InfraHealthController(OrderMapper orderMapper, StringRedisTemplate redisTemplate, KafkaTemplate<String,String> kafkaTemplate) {
        this.orderMapper = orderMapper;
        this.redisTemplate = redisTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/infra/health")
    public Map<String,Object> health() {
        Map<String,Object> r = new HashMap<>();
        try {
            Integer v = orderMapper.ping();
            r.put("mysqlPing", v);
        } catch (Exception e) {
            r.put("mysqlError", e.getMessage());
        }
        try {
            redisTemplate.opsForValue().set("infra:ping", "ok");
            r.put("redisPing", redisTemplate.opsForValue().get("infra:ping"));
        } catch (Exception e) {
            r.put("redisError", e.getMessage());
        }
        try {
            kafkaTemplate.metrics(); // 访问一下 metrics 代表客户端已初始化
            r.put("kafkaClient", "OK");
        } catch (Exception e) {
            r.put("kafkaError", e.getMessage());
        }
        return r;
    }
}

