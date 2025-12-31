package com.xs.boss.interfaces.web.user;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xs.boss.infrastructure.security.SecurityContextHolder;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息控制器
 * 演示如何在需要认证的接口中获取当前用户信息
 *
 * @author xiangshang
 */
@Slf4j
@Tag(name = "用户管理", description = "用户信息相关接口")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserInfoController {

//    /**
//     * 获取当前登录用户信息
//     * 该接口需要JWT认证（默认拦截 /api/** 路径）
//     */
//    @ApiOperationSupport(order = 1)
//    @Operation(summary = "获取当前用户信息", description = "获取当前登录用户的详细信息")
//    @GetMapping("/current")
//    public HttpResponseEntity<UserInfoVO> getCurrentUser() {
//
//
//        return HttpResponseEntity.ok(vo);
//    }


}

