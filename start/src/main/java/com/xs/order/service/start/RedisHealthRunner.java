package com.xs.order.service.start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisHealthRunner implements CommandLineRunner {

    private final StringRedisTemplate redisTemplate;
    private final Environment env;
    private final RedisConnectionFactory factory;

    public RedisHealthRunner(StringRedisTemplate redisTemplate, Environment env, RedisConnectionFactory factory) {
        this.redisTemplate = redisTemplate;
        this.env = env;
        this.factory = factory;
    }

    @Override
    public void run(String... args) {
        boolean cluster = env.getProperty("spring.data.redis.cluster.nodes[0]") != null; // list index detection
        System.out.println("[RedisHealth] detected=" + (cluster ? "cluster" : "standalone"));
        try {
            String key = "health:ping";
            redisTemplate.opsForValue().set(key, "pong", java.time.Duration.ofSeconds(30));
            String val = redisTemplate.opsForValue().get(key);
            System.out.println("[RedisHealth] SET/GET ok value=" + val);
            if (cluster) {
                try {
                    RedisClusterConnection cc = factory.getClusterConnection();
                    for (RedisClusterNode node : cc.clusterGetNodes()) {
                        if (node.isMaster()) {
                            System.out.println("[RedisHealth] master=" + node.getHost() + ":" + node.getPort() + " slots=" + node.getSlotRange());
                        }
                    }
                } catch (Exception e) {
                    System.err.println("[RedisHealth] cluster node fetch failed: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("[RedisHealth] Redis ping failed: " + e);
            Throwable cause = e.getCause();
            int depth = 0;
            while (cause != null && depth < 5) {
                System.err.println("[RedisHealth] cause" + depth + ": " + cause);
                cause = cause.getCause();
                depth++;
            }
        }
    }
}
