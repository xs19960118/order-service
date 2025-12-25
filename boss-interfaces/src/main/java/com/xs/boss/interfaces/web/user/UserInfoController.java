package com.xs.boss.interfaces.web.user;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xs.boss.domain.user.model.CurrentUser;
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

    /**
     * 获取当前登录用户信息
     * 该接口需要JWT认证（默认拦截 /api/** 路径）
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "获取当前用户信息", description = "获取当前登录用户的详细信息")
    @GetMapping("/current")
    public HttpResponseEntity<UserInfoVO> getCurrentUser() {
        // 从上下文中获取当前用户
        CurrentUser currentUser = SecurityContextHolder.getCurrentUser();
        
        if (currentUser == null) {
            return HttpResponseEntity.fail("未登录");
        }

        log.info("获取当前用户信息: userId={}, username={}", 
                currentUser.getUserId(), currentUser.getUsername());

        UserInfoVO vo = new UserInfoVO();
        vo.setUserId(currentUser.getUserId());
        vo.setUsername(currentUser.getUsername());
        vo.setRealName(currentUser.getRealName());
        vo.setMobile(currentUser.getMobile());
        vo.setEmail(currentUser.getEmail());
        vo.setRole(currentUser.getRole());

        return HttpResponseEntity.ok(vo);
    }

    /**
     * 修改用户信息
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "修改用户信息", description = "修改当前登录用户的信息")
    @PutMapping("/update")
    public HttpResponseEntity<String> updateUserInfo(@RequestBody UpdateUserInfoCmd cmd) {
        Long currentUserId = SecurityContextHolder.getCurrentUserId();
        
        log.info("修改用户信息: userId={}, realName={}", currentUserId, cmd.getRealName());
        
        // TODO: 实现修改用户信息逻辑
        
        return HttpResponseEntity.ok("修改成功");
    }

    /**
     * 查询其他用户信息
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "查询用户信息", description = "根据用户ID查询用户信息")
    @GetMapping("/{userId}")
    public HttpResponseEntity<UserInfoVO> getUserById(@PathVariable Long userId) {
        log.info("查询用户信息: userId={}", userId);
        
        // TODO: 实现查询用户信息逻辑
        
        UserInfoVO vo = new UserInfoVO();
        vo.setUserId(userId);
        vo.setUsername("demo_user");
        
        return HttpResponseEntity.ok(vo);
    }

    // ========== DTO 定义 ==========

    @Data
    public static class UserInfoVO {
        private Long userId;
        private String username;
        private String realName;
        private String mobile;
        private String email;
        private String role;
    }

    @Data
    public static class UpdateUserInfoCmd {
        private String realName;
        private String email;
        private String mobile;
    }
}

