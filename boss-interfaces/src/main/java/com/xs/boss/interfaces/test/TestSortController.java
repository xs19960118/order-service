package com.xs.boss.interfaces.test;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiangshang
 */
@Slf4j
@Tag(name = "@ApiOperationSupport 测试", description = "@ApiOperationSupport 测试排序")
@RestController
@RequestMapping("/test/test-order")
@RequiredArgsConstructor
@ApiSort(1)
public class TestSortController {


    @ApiOperationSupport(author = "xs", order = 2)
    @Operation(summary = "测试接口排序-1", description = "测试而已")
    @GetMapping("/ping")
    public HttpResponseEntity<String> ping1() {
        return HttpResponseEntity.ok("pong1");
    }

    @ApiOperationSupport(author = "xs", order = 1)
    @Operation(summary = "测试接口排序-2", description = "测试而已")
    @GetMapping("/ping2")
    public HttpResponseEntity<String> ping2() {
        return HttpResponseEntity.ok("pong2");
    }



}
