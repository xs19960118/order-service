package com.xs.boss.interfaces.web.order;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制器
 * 
 * @author xiangshang
 */
@Slf4j
@Tag(name = "订单-创建/查询", description = "订单创建、查询等相关接口")
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {



}
