package com.xs.order.service.infrastructure.persistence.po.report;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单表 PO（Report 数据源）
 * 
 * 对应表：orders
 *
 * @author xiangshang
 */
@Data
@TableName("orders")
public class OrdersPO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单类型
     */
    private Integer type;

    /**
     * 设计编码
     */
    private String designCode;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 案例编码
     */
    private String caseCode;

    /**
     * 业务编码
     */
    private String bizCode;

    /**
     * 区域
     */
    private String region;

    /**
     * 父订单编码
     */
    private String parentOrderCode;

    /**
     * 冲销订单编码
     */
    private String reversalOrderCode;

    /**
     * 工厂
     */
    private String factory;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 产品编码
     */
    private String productCode;

    /**
     * 修改用户ID
     */
    private Long modifyUid;

    /**
     * 分配用户ID
     */
    private Long assignUid;

    /**
     * 创建用户ID
     */
    private Long createUid;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 产品价格
     */
    private BigDecimal productPrice;

    /**
     * 货币
     */
    private String currency;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 确认时间
     */
    private LocalDateTime timeConfirm;

    /**
     * 发票金额
     */
    private BigDecimal amountInvoice;

    /**
     * 核销金额
     */
    private BigDecimal amountVerification;

    /**
     * 核销时间
     */
    private LocalDateTime timeVerified;

    /**
     * 收入状态
     */
    private Integer incomeStatus;

    /**
     * 对账状态
     */
    private Integer checkingStatus;

    /**
     * 发票状态
     */
    private Integer invoiceStatus;

    /**
     * 核销状态
     */
    private Integer verificationStatus;

    /**
     * 完成状态
     */
    private Integer finishStatus;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 患者编码
     */
    private String patientCode;

    /**
     * 医生编码
     */
    private String doctorCode;

    /**
     * BA 编码
     */
    private String baCode;

    /**
     * 分组编码
     */
    private String groupCode;

    /**
     * 账户编码
     */
    private String accountCode;

    /**
     * 合同编码
     */
    private String contractCode;

    /**
     * 发票目标类型
     */
    private Integer invoiceTargetType;

    /**
     * 结算目标类型
     */
    private Integer settlementTargetType;

    /**
     * 流程类型
     */
    private Integer processType;

    /**
     * 流程时间
     */
    private LocalDateTime timeProcess;

    /**
     * 标签位
     */
    private Long labelBit;

    /**
     * 备注
     */
    private String note;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 结算创建标识
     */
    private Integer settlementCreated;

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
     * 完成时间
     */
    private LocalDateTime timeFinish;
}

