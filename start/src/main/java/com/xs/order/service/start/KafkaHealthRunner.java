package com.xs.order.service.start;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.common.Node;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaHealthRunner implements CommandLineRunner {

    private final KafkaAdmin kafkaAdmin;

    public KafkaHealthRunner(KafkaAdmin kafkaAdmin) {
        this.kafkaAdmin = kafkaAdmin;
    }

    @Override
    public void run(String... args) {
        Map<String, Object> props = kafkaAdmin.getConfigurationProperties();
        try (AdminClient client = AdminClient.create(props)) {
            DescribeClusterResult describeClusterResult = client.describeCluster();
            String clusterId = describeClusterResult.clusterId().get(5, TimeUnit.SECONDS);
            Collection<Node> nodes = describeClusterResult.nodes().get(5, TimeUnit.SECONDS);
            System.out.println("[KafkaHealth] clusterId=" + clusterId + " nodes=" + nodes.size());
            for (Node node : nodes) {
                System.out.println("[KafkaHealth] node=" + node.id() + " " + node.host() + ":" + node.port());
            }
            ListTopicsResult topicsResult = client.listTopics(new ListTopicsOptions().timeoutMs(5000));
            System.out.println("[KafkaHealth] topics=" + topicsResult.names().get().size());
        } catch (Exception e) {
            System.err.println("[KafkaHealth] Kafka check failed: " + e.getMessage());
            Throwable cause = e.getCause();
            int depth = 0;
            while (cause != null && depth < 5) {
                System.err.println("[KafkaHealth] cause" + depth + ": " + cause.getMessage());
                cause = cause.getCause();
                depth++;
            }
        }
    }
}

