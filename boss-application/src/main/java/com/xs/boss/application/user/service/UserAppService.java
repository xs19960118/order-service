package com.xs.boss.application.user.service;

import com.xs.boss.application.user.dto.ExchangeTokenDTO;
import com.xs.boss.application.user.dto.ExchangeTokenResDTO;

/**
 * 用户应用服务接口
 * <p>
 * 应用层 - 负责编排业务流程，协调领域服务
 * <p>
 * 注意：
 * - 应用层不依赖接口层，使用应用层自己的 DTO
 * - 应用层返回给接口层的也是应用层自己的 DTO，不暴露领域对象
 *
 * @author xiangshang
 */
public interface UserAppService {

    /**
     * 通过 ticket 换取 token
     *
     * @param dto 换取 token 的 DTO（应用层自己的 DTO）
     * @return ExchangeTokenResultDTO 应用层返回 DTO，不暴露领域对象
     */
    ExchangeTokenResDTO exchangeToken(ExchangeTokenDTO dto);
}

