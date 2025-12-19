package com.xs.order.service.interfaces.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 订单控制器
 * 
 * @author xiangshang
 */
@Slf4j
@Tag(name = "测试", description = "测试接口")
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {


    @ApiOperationSupport(author = "xs", order = 2)
    @Operation(summary = "测试接口排序-1", description = "测试订单服务是否正常运行")
    @GetMapping("/ping")
    public HttpResponseEntity<String> ping1() {
        return HttpResponseEntity.ok("pong1");
    }

    @ApiOperationSupport(author = "xs", order = 1)
    @Operation(summary = "测试接口排序-2", description = "测试订单服务是否正常运行")
    @GetMapping("/ping2")
    public HttpResponseEntity<String> ping2() {
        return HttpResponseEntity.ok("pong2");
    }



}
