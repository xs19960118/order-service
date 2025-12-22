package com.xs.order.service.infrastructure.persistence.po.report;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单明细表 PO（Report 数据源）
 * 
 * 对应表：order_items
 *
 * @author xiangshang
 */
@Data
@TableName("order_items")
public class OrderItemsPO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 明细编码
     */
    private String code;

    /**
     * 索引
     */
    private Integer index;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 产品编码
     */
    private String productCode;

    /**
     * 标签位
     */
    private Long labelBit;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 产品价格
     */
    private BigDecimal productPrice;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除时间（逻辑删除）
     */
    @TableLogic
    private LocalDateTime deleteTime;

    /**
     * 颌位
     */
    private String jaw;

    /**
     * 零价格标识
     */
    private Integer priceZero;
}

