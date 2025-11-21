package com.xs.order.service.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiangshang
 */
@SpringBootApplication(scanBasePackages = "com.xs.order.service")
@MapperScan("com.xs.order.service.infrastructure.persistence.mapper")
public class StartApplication {
    private static final Logger logger = LoggerFactory.getLogger(StartApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Bean
    public org.springframework.boot.CommandLineRunner checkConfig(Environment env) {
        return args -> logger.info("Loaded spring.application.name = {}", env.getProperty("spring.application.name"));
    }
}
