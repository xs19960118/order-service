package com.xs.boss.interfaces.web.auth;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xs.boss.infrastructure.security.JwtTokenProvider;
import com.xs.boss.infrastructure.security.SkipAuth;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证控制器
 * 用于登录、注册等不需要JWT认证的接口
 *
 * @author xiangshang
 */
@Slf4j
@Tag(name = "认证管理", description = "登录、注册等认证相关接口")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 登录接口（模拟）
     * 实际项目中应该验证用户名密码，这里仅作演示
     */
    @SkipAuth("登录接口，无需认证")
    @ApiOperationSupport(order = 1)
    @Operation(summary = "用户登录", description = "用户登录获取JWT Token")
    @PostMapping("/login")
    public HttpResponseEntity<LoginVO> login(@RequestBody LoginCmd cmd) {
        log.info("用户登录: username={}", cmd.getUsername());

        // TODO: 实际项目中应该：
        // 1. 验证用户名密码
        // 2. 查询用户信息
        // 3. 将用户信息存入Redis（可选）

        // 模拟用户ID
        Long userId = 10001L;

        // 构造 Token Payload（可以放一些用户基本信息）
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", cmd.getUsername());
        payload.put("realName", "张三");
        payload.put("role", "admin");

        // 生成 Token
        String token = jwtTokenProvider.generateToken(userId, payload);

        LoginVO vo = new LoginVO();
        vo.setToken(token);
        vo.setUserId(userId);
        vo.setUsername(cmd.getUsername());
        vo.setExpireIn(28800L); // 8小时

        log.info("登录成功: userId={}, token={}", userId, token.substring(0, 20) + "...");
        return HttpResponseEntity.ok(vo);
    }

    /**
     * 刷新Token接口
     */
    @SkipAuth("刷新Token，无需认证")
    @ApiOperationSupport(order = 2)
    @Operation(summary = "刷新Token", description = "使用旧Token刷新获取新Token")
    @PostMapping("/refresh")
    public HttpResponseEntity<LoginVO> refresh(@RequestHeader("Authorization") String authorization) {
        log.info("刷新Token");

        // 提取 Token
        String token = authorization.replace("Bearer ", "");

        // 验证并解析旧Token
        Long userId = jwtTokenProvider.getUserIdFromToken(token);

        // 生成新Token
        String newToken = jwtTokenProvider.generateToken(userId, null);

        LoginVO vo = new LoginVO();
        vo.setToken(newToken);
        vo.setUserId(userId);
        vo.setExpireIn(28800L);

        return HttpResponseEntity.ok(vo);
    }

    /**
     * 注册接口（占位）
     */
    @SkipAuth("注册接口，无需认证")
    @ApiOperationSupport(order = 3)
    @Operation(summary = "用户注册", description = "新用户注册")
    @PostMapping("/register")
    public HttpResponseEntity<String> register(@RequestBody RegisterCmd cmd) {
        log.info("用户注册: username={}", cmd.getUsername());
        // TODO: 实现注册逻辑
        return HttpResponseEntity.ok("注册功能待实现");
    }

    // ========== DTO 定义 ==========

    @Data
    public static class LoginCmd {
        private String username;
        private String password;
    }

    @Data
    public static class RegisterCmd {
        private String username;
        private String password;
        private String email;
        private String mobile;
    }

    @Data
    public static class LoginVO {
        private String token;
        private Long userId;
        private String username;
        private Long expireIn;
    }
}

