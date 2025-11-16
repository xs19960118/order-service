package com.xs.order.service.start;

import com.xs.order.service.infrastructure.persistence.mapper.OrderMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbHealthRunner implements CommandLineRunner {

    private final OrderMapper orderMapper;

    public DbHealthRunner(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void run(String... args) {
        try {
            Integer v = orderMapper.ping();
            System.out.println("MySQL ping via MyBatis-Plus routing result = " + v);
        } catch (Exception e) {
            System.err.println("MySQL ping failed: " + e.getMessage());
        }
    }
}

