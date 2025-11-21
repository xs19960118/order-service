package com.xs.order.service.interfaces.web.order;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 订单控制器
 * 
 * @author xiangshang
 * @since 2023-12-01
 */
@Slf4j
@Tag(name = "订单-创建/查询", description = "订单创建、查询等相关接口")
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {


    @ApiOperationSupport(author = "xs")
    @Operation(summary = "健康检查", description = "检查订单服务是否正常运行")
    @GetMapping("/ping")
    public String ping() {
        return "OK";
    }
}
