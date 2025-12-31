package com.xs.boss.interfaces.dto.qry.user;

import com.xs.boss.application.user.dto.ExchangeTokenDTO;
import com.xs.boss.infrastructure.enums.ErrorCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import static com.xs.boss.infrastructure.exception.BossBusinessException.throwIfNull;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * @author xiangshang
 */
@Schema(description = "客户端通过 ticket 换取 token 的 req")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeTokenQry {

    @NotBlank(message = "ticket 不能为空")
    @Schema(description = "ticket", type = "string", requiredMode = REQUIRED)
    private String ticket;

    @NotBlank(message = "服务端地址不能为空")
    @Schema(description = "服务端地址", type = "string", requiredMode = REQUIRED)
    private String serverUrl;

    /**
     * 转换为应用层 DTO
     *
     * @param exchangeTokenQry 接口层查询对象（不能为 null）
     * @return 应用层 DTO
     */
    public static ExchangeTokenDTO toDTO(@NonNull ExchangeTokenQry exchangeTokenQry) {
        throwIfNull(exchangeTokenQry, ErrorCodeEnum.PARAM_ERROR, "exchangeTokenQry 不可为空");

        return ExchangeTokenDTO.builder()
                .ticket(exchangeTokenQry.getTicket())
                .serverUrl(exchangeTokenQry.getServerUrl())
                .build();
    }
}
