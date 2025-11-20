package com.xs.order.service.interfaces.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Order Service API")
                        .description("Order Service 模块接口文档")
                        .version("v1.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Your Name") // 请替换为实际作者名
                                .url("http://example.com") // 请替换为实际作者网址
                                .email("your-email@example.com")) // 请替换为实际作者邮箱
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))

                .externalDocs(new ExternalDocumentation()
                        .description("项目仓库")
                        .url("http://example.com/docs"));
    }
}

