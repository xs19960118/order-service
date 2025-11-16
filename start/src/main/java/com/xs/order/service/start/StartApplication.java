package com.xs.order.service.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.xs.order.service")
@MapperScan("com.xs.order.service.infrastructure.persistence.mapper")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Bean
    public org.springframework.boot.CommandLineRunner checkConfig(Environment env) {
        return args -> System.out.println("Loaded spring.application.name = " + env.getProperty("spring.application.name"));
    }
}
