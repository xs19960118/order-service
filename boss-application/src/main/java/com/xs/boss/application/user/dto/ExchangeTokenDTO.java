package com.xs.boss.application.user.dto;

import com.xs.boss.domain.user.model.TicketInfo;
import com.xs.boss.infrastructure.enums.ErrorCodeEnum;
import lombok.*;

import static com.xs.boss.infrastructure.exception.BossBusinessException.throwIfNull;

/**
 * @author xiangshang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeTokenDTO {

    /**
     * Ticket 值
     */
    private String ticket;

    /**
     * 服务端地址
     */
    private String serverUrl;


    public static TicketInfo toTicketInfo(@NonNull ExchangeTokenDTO dto) {
        throwIfNull(dto, ErrorCodeEnum.PARAM_ERROR, "ExchangeTokenDTO.toTicketInfo()，传入的 dto 不可为空");
        return TicketInfo.builder()
                .ticket(dto.getTicket())
                .serverUrl(dto.getServerUrl())
                .build();
    }
}

