package com.xs.order.service.infrastructure.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 多数据源配置类
 * 配置三个数据源：Boss（主）、CRM、Report
 *
 * @author xiangshang
 */
@Configuration
public class DataSourceConfig {

    /**
     * Boss 数据源（主数据源）
     * 用于订单服务的主要业务数据
     */
    @Primary
    @Bean(name = "bossDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.boss")
    public DataSource bossDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    /**
     * CRM 数据源
     * 用于客户关系管理相关数据
     */
    @Bean(name = "crmDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.crm")
    public DataSource crmDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    /**
     * Report 数据源
     * 用于报表统计相关数据
     */
    @Bean(name = "reportDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.report")
    public DataSource reportDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }
}

