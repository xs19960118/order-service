package com.xs.order.service.infrastructure.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.core.env.Environment;
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
    @Value("${spring.datasource.readonly.enabled:true}")
    private boolean enableSlaves;

    private final Environment env;
    public DynamicDataSourceConfig(Environment env) { this.env = env; }

    @Bean
    @ConditionalOnMissingBean(name = "dataSource")
    public DataSource dataSource() {
        HikariDataSource master = build(masterUrl, masterUsername, masterPassword, masterDriver);
        Map<Object,Object> targets = new HashMap<>();
        targets.put("master", master);
        List<String> slaveKeys = enableSlaves ? loadSlaves(targets) : Collections.emptyList();
        AtomicInteger rr = new AtomicInteger();
        AbstractRoutingDataSource routing = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                DataSourceRole role = DataSourceContextHolder.getRole();
                String key;
                if (role == DataSourceRole.SLAVE && enableSlaves && !slaveKeys.isEmpty()) {
                    int idx = Math.abs(rr.getAndIncrement()) % slaveKeys.size();
                    key = slaveKeys.get(idx);
                } else {
                    key = "master";
                }
                if (log.isDebugEnabled()) {
                    log.debug("[DynamicDS] role={} route={} slaves={} enabled={}", role, key, slaveKeys, enableSlaves);
                }
                return key;
            }
        };
        routing.setDefaultTargetDataSource(master);
        routing.setTargetDataSources(new HashMap<>(targets));
        routing.afterPropertiesSet();
        log.info("Dynamic DataSource initialized: master + {} slaves {} (enabled={})", slaveKeys.size(), slaveKeys, enableSlaves);
        return routing;
    }

    private List<String> loadSlaves(Map<Object,Object> targets) {
        List<String> slaveKeys = new ArrayList<>();
        for (int i = 0; ; i++) {
            String prefix = "spring.datasource.slaves[" + i + "].";
            String url = env.getProperty(prefix + "url");
            if (url == null) break;
            String user = env.getProperty(prefix + "username", masterUsername);
            String pwd = env.getProperty(prefix + "password", masterPassword);
            String driver = env.getProperty(prefix + "driver-class-name", masterDriver);
            String key = "slave-" + i;
            try {
                HikariDataSource ds = build(url, user, pwd, driver);
                try {
                    ds.getConnection().close();
                } catch (Exception probeEx) {
                    log.warn("Probe on {} returned '{}' (kept)", key, probeEx.getMessage());
                }
                targets.put(key, ds);
                slaveKeys.add(key);
                log.info("Added slave {} url={}", key, url);
            } catch (Exception e) {
                log.warn("Skip slave {} url={} reason={}", key, url, e.getMessage());
            }
        }
        return slaveKeys;
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
