package com.xs.order.service.start;

import com.xs.order.service.infrastructure.persistence.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbHealthRunner implements CommandLineRunner {

    private final OrderMapper orderMapper;
    @Value("${spring.datasource.readonly.enabled:true}")
    private boolean slaveEnabled;

    public DbHealthRunner(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void run(String... args) {
        try {
            Integer v = orderMapper.ping();
            System.out.println("MySQL ping (slaves enabled=" + slaveEnabled + ") result = " + v);
        } catch (Exception e) {
            System.err.println("MySQL ping failed: " + e.getMessage());
        }
    }
}
