package com.xs.order.service.infrastructure.persistence.po.report;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 退款表 PO（Report 数据源）
 * 
 * 对应表：refunds
 *
 * @author xiangshang
 */
@Data
@TableName("refunds")
public class RefundsPO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 退款编码
     */
    private String code;

    /**
     * 实例ID
     */
    private String instanceId;

    /**
     * 实例URL
     */
    private String instanceUrl;

    /**
     * 退款原因
     */
    private String reason;

    /**
     * 备注
     */
    private String note;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建用户ID
     */
    private Long createUid;

    /**
     * 标签位
     */
    private Long labelBit;

    /**
     * 版本号
     */
    private Integer version;

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
}

