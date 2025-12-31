package com.xs.boss.interfaces.dto.vo.user;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.xs.boss.application.user.dto.ExchangeTokenResDTO;
import com.xs.boss.infrastructure.enums.ErrorCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import static com.xs.boss.infrastructure.exception.BossBusinessException.throwIfNull;

/**
 * 客户端通过 ticket 换取 token 的响应 VO
 *
 * @author xiangshang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "客户端通过 ticket 换取 token 的 VO")
@JsonPropertyOrder({"accessToken", "tokenType", "expiresIn"})
public class ExchangeTokenVO {

    @Schema(description = "访问令牌", type = "string", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...", requiredMode = Schema.RequiredMode.REQUIRED)
    private String accessToken;

    @Schema(description = "访问令牌类型", type = "string", example = "Bearer", requiredMode = Schema.RequiredMode.REQUIRED)
    private String tokenType;

    @Schema(description = "过期时间（秒）", type = "integer", example = "28800", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer expiresIn;

    public static ExchangeTokenVO toVO(@NonNull ExchangeTokenResDTO resDTO) {
        throwIfNull(resDTO, ErrorCodeEnum.PARAM_ERROR, "ExchangeTokenResDTO 不能为空");

        return ExchangeTokenVO.builder()
                .accessToken(resDTO.getAccessToken())
                .tokenType(resDTO.getTokenType())
                .expiresIn(resDTO.getExpiresIn())
                .build();
    }
}
