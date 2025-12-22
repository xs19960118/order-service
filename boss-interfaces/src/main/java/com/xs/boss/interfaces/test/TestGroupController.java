package com.xs.boss.interfaces.test;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangshang
 */
@Slf4j
@Tag(name = "测试控制器的", description = "")
@RestController
@RequestMapping("/test/test-order")
@RequiredArgsConstructor
@ApiSort(2)
public class TestGroupController {
}
