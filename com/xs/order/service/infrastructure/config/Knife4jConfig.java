    @Bean
    public GroupedOpenApi orderApi() {
        return GroupedOpenApi.builder()
                .group("订单")
                .pathsToMatch("/api/orders/**")
                .order(1) // 设置订单服务分组的显示顺序
                .order(2) // 设置用户服务分组的显示顺序
                .order(3) // 设置支付服务分组的显示顺序
                .order(4) // 设置测试服务分组的显示顺序
                .build();
    }
