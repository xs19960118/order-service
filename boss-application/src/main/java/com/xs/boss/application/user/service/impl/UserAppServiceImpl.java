package com.xs.boss.application.user.service.impl;

import com.xs.boss.application.user.dto.ExchangeTokenDTO;
import com.xs.boss.application.user.dto.ExchangeTokenResDTO;
import com.xs.boss.application.user.service.UserAppService;
import com.xs.boss.domain.user.model.TicketInfo;
import com.xs.boss.domain.user.service.TicketDomainService;
import com.xs.boss.infrastructure.config.JwtConfig;
import com.xs.boss.infrastructure.exception.BossBusinessException;
import com.xs.boss.infrastructure.enums.ErrorCodeEnum;
import com.xs.boss.infrastructure.security.JwtTokenProvider;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xiangshang
 */
@Slf4j
@Service
public class UserAppServiceImpl implements UserAppService {

    @Resource
    private TicketDomainService ticketDomainService;

    @Resource
    private JwtTokenProvider jwtTokenProvider;

    @Resource
    private JwtConfig jwtConfig;

    @Override
    public ExchangeTokenResDTO exchangeToken(ExchangeTokenDTO dto) {
        log.info("开始通过 ticket 换取 token, ticket={}, serverUrl={}", dto.getTicket(), dto.getServerUrl());

        try {
            // 调用领域服务验证 ticket 并获取 ticket 信息
            TicketInfo ticketInfo = ticketDomainService.validateAndGetTicketInfo(ExchangeTokenDTO.toTicketInfo(dto));

            // 构建 payload
            Map<String, Object> payload = Map.of(
                    "username", ticketInfo.getUsername(),
                    "sub", ticketInfo.getUsername()
            );

            // 生成 token
            String accessToken = jwtTokenProvider.generateToken(payload);

            Integer expiresIn = jwtConfig.getExpire().intValue();

            return ExchangeTokenResDTO.builder()
                    .accessToken(accessToken)
                    .tokenType("Bearer")
                    .expiresIn(expiresIn)
                    .build();

        } catch (Throwable e) {
            log.warn("Ticket 换取 token 失败: {}", e.getMessage());
            throw new BossBusinessException(ErrorCodeEnum.BUSINESS_ERROR, e.getMessage());
        }
    }
}

