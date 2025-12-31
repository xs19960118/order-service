package com.xs.boss.application.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 换取 Token 结果 DTO
 * <p>
 * 应用层 - 应用层返回给接口层的 DTO，不暴露领域对象
 * <p>
 * 注意：Application 层返回给 Interface 层的对象，Interface 层不应该直接依赖 Domain 对象
 *
 * @author xiangshang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeTokenResDTO {

    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 令牌类型（如 Bearer）
     */
    private String tokenType;

    /**
     * 过期时间（秒）
     */
    private Integer expiresIn;
}

