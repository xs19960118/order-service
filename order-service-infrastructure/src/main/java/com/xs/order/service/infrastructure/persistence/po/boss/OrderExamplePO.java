package com.xs.order.service.infrastructure.persistence.po.boss;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单 PO 示例（Boss 数据源）
 * 
 * 这是一个示例 PO 对象，展示如何定义 Boss 数据源的持久化对象
 *
 * @author xiangshang
 */
@Data
@TableName("orders")
public class OrderExamplePO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * 订单状态
     * 0-待支付，1-已支付，2-已取消，3-已完成
     */
    private Integer status;

    /**
     * 逻辑删除标识
     * 0-未删除，1-已删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}

