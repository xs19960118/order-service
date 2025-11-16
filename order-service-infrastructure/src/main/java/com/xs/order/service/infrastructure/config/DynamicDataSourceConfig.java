package com.xs.order.service.infrastructure.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class DynamicDataSourceConfig {

    @Value("${spring.datasource.master.url}")
    private String masterUrl;
    @Value("${spring.datasource.master.username}")
    private String masterUsername;
    @Value("${spring.datasource.master.password}")
    private String masterPassword;
    @Value("${spring.datasource.master.driver-class-name}")
    private String masterDriver;

    @Value("${spring.datasource.slaves[0].url}")
    private String slave1Url;
    @Value("${spring.datasource.slaves[0].username}")
    private String slave1Username;
    @Value("${spring.datasource.slaves[0].password}")
    private String slave1Password;
    @Value("${spring.datasource.slaves[0].driver-class-name}")
    private String slave1Driver;

    @Value("${spring.datasource.slaves[1].url}")
    private String slave2Url;
    @Value("${spring.datasource.slaves[1].username}")
    private String slave2Username;
    @Value("${spring.datasource.slaves[1].password}")
    private String slave2Password;
    @Value("${spring.datasource.slaves[1].driver-class-name}")
    private String slave2Driver;

    @Bean
    @ConditionalOnMissingBean(name = "dataSource")
    public DataSource dataSource() {
        HikariDataSource master = build(masterUrl, masterUsername, masterPassword, masterDriver);
        HikariDataSource s1 = build(slave1Url, slave1Username, slave1Password, slave1Driver);
        HikariDataSource s2 = build(slave2Url, slave2Username, slave2Password, slave2Driver);

        Map<Object, Object> target = new HashMap<>();
        target.put("master", master);
        target.put("slave-0", s1);
        target.put("slave-1", s2);

        AtomicInteger idx = new AtomicInteger();
        AbstractRoutingDataSource routing = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                // 简单策略: 读操作路由到从库, 写默认 master (这里先全部走 master, 后续可加 ThreadLocal 标记)
                // 为演示先做轮询所有数据源: master + slave
                int i = idx.getAndIncrement() % target.size();
                if (i == 0) return "master";
                return "slave-" + (i - 1);
            }
        };
        routing.setDefaultTargetDataSource(master);
        routing.setTargetDataSources(target);
        routing.afterPropertiesSet();
        return routing;
    }

    private HikariDataSource build(String url, String username, String password, String driver) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        ds.setMaximumPoolSize(5);
        ds.setMinimumIdle(1);
        ds.setPoolName("order-ds-" + UUID.randomUUID());
        return ds;
    }
}

