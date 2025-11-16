package com.xs.order.service.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StartupLogListener implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger log = LoggerFactory.getLogger(StartupLogListener.class);
    private final Environment env;

    public StartupLogListener(Environment env) {
        this.env = env;
    }

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent event) {
        String port = env.getProperty("local.server.port", env.getProperty("server.port", "8080"));
        String contextPath = env.getProperty("server.servlet.context-path", "");
        if ("/".equals(contextPath)) {
            contextPath = "";
        }
        String baseUrl = "http://localhost:" + port + contextPath;
        log.info("服务启动成功 ✅");
        log.info("• 主页: {}/", baseUrl);
        log.info("• 健康检查: {}/orders/ping", baseUrl);
        log.info("• Swagger UI: {}/swagger-ui/index.html", baseUrl);
        log.info("• Knife4j: {}/doc.html (若已启用)", baseUrl);
    }
}
