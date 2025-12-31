package com.xs.boss.interfaces.web.user;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xs.boss.application.user.dto.ExchangeTokenDTO;
import com.xs.boss.application.user.dto.ExchangeTokenResDTO;
import com.xs.boss.application.user.service.UserAppService;
import com.xs.boss.infrastructure.annotation.SkipJWT;
import com.xs.boss.interfaces.dto.qry.user.ExchangeTokenQry;
import com.xs.boss.interfaces.dto.vo.user.ExchangeTokenVO;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息控制器
 * <p>
 * 接口层 - 只负责接收请求和返回响应，做简单的适配转换
 * <p>
 * 业务编排在 Application 层完成
 *
 * @author xiangshang
 */
@Slf4j
@Tag(name = "用户管理", description = "用户信息相关接口")
@RestController
@RequestMapping("/api/v1/user")
public class UserInfoController {

    @Resource
    private UserAppService userAppService;

    @SkipJWT
    @ApiOperationSupport(author = "xs", order = 1)
    @Operation(summary = "测试接口 ping", description = "测试接口")
    @GetMapping("/ping")
    public HttpResponseEntity<String> ping() {
        return HttpResponseEntity.ok("pong");
    }

    @SkipJWT
    @ApiOperationSupport(author = "xs", order = 2)
    @Operation(summary = "客户端通过 ticket 换取 token", description = "客户端通过 ticket 换取 token")
    @PostMapping("/exchange-token")
    public HttpResponseEntity<ExchangeTokenVO> getExchangeToken(@Valid @RequestBody ExchangeTokenQry exchangeTokenQry) {
        // Interface Qry → Application DTO
        ExchangeTokenDTO dto = ExchangeTokenQry.toDTO(exchangeTokenQry);

        // 调用应用层服务（业务编排在 Application 层完成）
        ExchangeTokenResDTO resDTO = userAppService.exchangeToken(dto);

        // Application Result DTO → Interface VO
        ExchangeTokenVO vo = ExchangeTokenVO.toVO(resDTO);

        return HttpResponseEntity.ok(vo);
    }
}

