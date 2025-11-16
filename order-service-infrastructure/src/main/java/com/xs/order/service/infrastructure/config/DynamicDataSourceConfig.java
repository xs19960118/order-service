package com.xs.order.service.infrastructure.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class DynamicDataSourceConfig {
    private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceConfig.class);

    @Value("${spring.datasource.master.url}") private String masterUrl;
    @Value("${spring.datasource.master.username}") private String masterUsername;
    @Value("${spring.datasource.master.password}") private String masterPassword;
    @Value("${spring.datasource.master.driver-class-name}") private String masterDriver;

    @Value("${spring.datasource.slaves[0].url}") private String slave1Url;
    @Value("${spring.datasource.slaves[0].username}") private String slave1Username;
    @Value("${spring.datasource.slaves[0].password}") private String slave1Password;
    @Value("${spring.datasource.slaves[0].driver-class-name}") private String slave1Driver;

    @Value("${spring.datasource.slaves[1].url}") private String slave2Url;
    @Value("${spring.datasource.slaves[1].username}") private String slave2Username;
    @Value("${spring.datasource.slaves[1].password}") private String slave2Password;
    @Value("${spring.datasource.slaves[1].driver-class-name}") private String slave2Driver;

    @Bean
    @ConditionalOnMissingBean(name = "dataSource")
    public DataSource dataSource() {
        HikariDataSource master = build(masterUrl, masterUsername, masterPassword, masterDriver);
        Map<Object,Object> targets = new HashMap<>();
        targets.put("master", master);
        List<String> slaveKeys = new ArrayList<>();
        addSlave(targets, slaveKeys, "slave-0", slave1Url, slave1Username, slave1Password, slave1Driver);
        addSlave(targets, slaveKeys, "slave-1", slave2Url, slave2Username, slave2Password, slave2Driver);
        AtomicInteger rr = new AtomicInteger();

        AbstractRoutingDataSource routing = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                DataSourceRole role = DataSourceContextHolder.getRole();
                if (role == DataSourceRole.SLAVE && !slaveKeys.isEmpty()) {
                    int idx = Math.abs(rr.getAndIncrement()) % slaveKeys.size();
                    return slaveKeys.get(idx);
                }
                return "master"; // default master for writes or no slaves
            }
        };
        routing.setDefaultTargetDataSource(master);
        routing.setTargetDataSources(new HashMap<>(targets));
        routing.afterPropertiesSet();
        log.info("Dynamic DataSource initialized: master + {} slaves", slaveKeys.size());
        return routing;
    }

    private void addSlave(Map<Object,Object> targets, List<String> slaveKeys, String key, String url, String user, String pwd, String driver) {
        try {
            HikariDataSource ds = build(url, user, pwd, driver);
            ds.getConnection().close(); // probe
            targets.put(key, ds);
            slaveKeys.add(key);
        } catch (Exception e) {
            log.warn("Skip slave {} url={} reason={}", key, url, e.getMessage());
        }
    }

    private HikariDataSource build(String url, String username, String password, String driver) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        ds.setMaximumPoolSize(8);
        ds.setMinimumIdle(2);
        ds.setPoolName("order-ds-" + UUID.randomUUID());
        return ds;
    }
}

// Holder & role definition
enum DataSourceRole { MASTER, SLAVE }
class DataSourceContextHolder {
    private static final ThreadLocal<DataSourceRole> CTX = new ThreadLocal<>();
    static void useMaster() { CTX.set(DataSourceRole.MASTER); }
    static void useSlave() { CTX.set(DataSourceRole.SLAVE); }
    static DataSourceRole getRole() { return CTX.get() == null ? DataSourceRole.MASTER : CTX.get(); }
    static void clear() { CTX.remove(); }
}
