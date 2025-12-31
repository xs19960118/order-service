package com.xs.boss.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Token 领域模型
 * <p>
 * 领域层 - Domain Model（领域模型）
 * <p>
 * 注意：这是 Domain Model，不是 Value Object
 * - Value Object 应该是不可变的（immutable）
 * - 此对象是可变的，用于在领域层传递 token 相关信息
 *
 * @author xiangshang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo implements Serializable {

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

