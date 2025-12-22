package com.xs.order.service.infrastructure.persistence.po.report;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 订单报表 PO 示例（Report 数据源）
 * 
 * 这是一个示例 PO 对象，展示如何定义 Report 数据源的持久化对象
 *
 * @author xiangshang
 */
@Data
@TableName("order_daily_report")
public class OrderReportExamplePO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 报表日期
     */
    private LocalDate reportDate;

    /**
     * 订单总数
     */
    private Integer totalOrders;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 已支付订单数
     */
    private Integer paidOrders;

    /**
     * 已支付订单金额
     */
    private BigDecimal paidAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}

