package com.xs.order.service.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j 配置类
 *
 * @author xiangshang
 */
@Configuration
public class Knife4jConfig {


    /**
     * 配置 OpenAPI 文档信息
     *
     * @return OpenAPI 实例
     */
    @Bean
    public OpenAPI orderServiceOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Service API")
                        .description("Order Service 模块接口文档")
                        .version("v1.0")
                        .contact(new Contact()
                                // 请替换为实际作者名
                                .name("Your Name")
                                // 请替换为实际作者网址
                                .url("http://example.com")
                                // 请替换为实际作者邮箱
                                .email("your-email@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("项目文档")
                        .url("/doc.html"));
    }

//    /**
//     * 订单服务分组
//     * 注意：分组名称前加数字前缀控制排序（1-订单、2-用户、3-支付、4-测试）
//     */
//    @Bean
//    public GroupedOpenApi orderApi() {
//        return GroupedOpenApi.builder()
//                .group("1-订单")
//                .pathsToMatch("/api/orders/**")
//                .build();
//    }
//
//    /**
//     * 用户服务分组
//     */
//    @Bean
//    public GroupedOpenApi userApi() {
//        return GroupedOpenApi.builder()
//                .group("2-用户")
//                .pathsToMatch("/api/users/**")
//                .build();
//    }
//
//    /**
//     * 支付服务分组
//     */
//    @Bean
//    public GroupedOpenApi paymentApi() {
//        return GroupedOpenApi.builder()
//                .group("3-支付")
//                .pathsToMatch("/api/payments/**")
//                .build();
//    }
//
//    /**
//     * 测试分组
//     */
//    @Bean
//    public GroupedOpenApi testApi() {
//        return GroupedOpenApi.builder()
//                .group("4-测试")
//                .pathsToMatch("/test/**")
//                .build();
//    }

}