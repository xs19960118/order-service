package com.xs.boss.interfaces.dto.qry;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 订单数据传输对象
 * 
 * @author xiangshang
 */
@Data
@Schema(description = "订单数据传输对象")
public class OrderBaseInfoQry {

    @Schema(description = "订单ID", example = "1")
    private Long id;

    @Schema(description = "订单号", example = "ORD202312010001", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    @Schema(description = "用户ID", example = "1001", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "用户ID不能为空")
    @Positive(message = "用户ID必须是正数")
    private Long userId;

}
