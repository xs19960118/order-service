package com.xs.boss.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author xiangshang
 */
public class InfrastructureConfigTest {

    private static final Logger logger = LoggerFactory.getLogger(InfrastructureConfigTest.class);

    @Bean
    public String infrastructureConfigLoaded() {
        logger.info("=== Infrastructure 配置类验证 ===");
        logger.info("✅ InfrastructureConfigTest 已被 Spring 加载");
        logger.info("=== 验证完成 ===");
        return "infrastructure-config-loaded";
    }
}
