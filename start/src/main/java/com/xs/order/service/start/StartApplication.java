package com.xs.order.service.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = "com.xs.order.service")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Bean
    public org.springframework.boot.CommandLineRunner checkConfig(Environment env) {
        return args -> System.out.println("Loaded spring.application.name = " + env.getProperty("spring.application.name"));
    }
}
