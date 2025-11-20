package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 预处理订单
 * @TableName au_order_prepare_extra
 */
@TableName(value ="au_order_prepare_extra")
@Data
public class AuOrderPrepareExtraPO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单类型， 2.矫治器, 11.附属订单
     */
    private Integer type;

    /**
     * 单据编号
     */
    private String processCode;

    /**
     * 发票号
     */
    private String invoiceNumber;

    /**
     * 单据编号
     */
    private String orderCode;

    /**
     * 目标金额
     */
    private BigDecimal targetAmount;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 币种
     */
    private String currency;

    /**
     * 目标优惠金额
     */
    private BigDecimal targetDiscount;

    /**
     * 目标销售主体
     */
    private Integer targetRegion;

    /**
     * 动作: 1.取消, 2.变更, 3.转订单
     */
    private Integer actionType;

    /**
     * 状态: 0.待处理, 1.已处理, 2.处理失败
     */
    private Integer status;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AuOrderPrepareExtraPO other = (AuOrderPrepareExtraPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getProcessCode() == null ? other.getProcessCode() == null : this.getProcessCode().equals(other.getProcessCode()))
            && (this.getInvoiceNumber() == null ? other.getInvoiceNumber() == null : this.getInvoiceNumber().equals(other.getInvoiceNumber()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getTargetAmount() == null ? other.getTargetAmount() == null : this.getTargetAmount().equals(other.getTargetAmount()))
            && (this.getTaxRate() == null ? other.getTaxRate() == null : this.getTaxRate().equals(other.getTaxRate()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getTargetDiscount() == null ? other.getTargetDiscount() == null : this.getTargetDiscount().equals(other.getTargetDiscount()))
            && (this.getTargetRegion() == null ? other.getTargetRegion() == null : this.getTargetRegion().equals(other.getTargetRegion()))
            && (this.getActionType() == null ? other.getActionType() == null : this.getActionType().equals(other.getActionType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getError() == null ? other.getError() == null : this.getError().equals(other.getError()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getProcessCode() == null) ? 0 : getProcessCode().hashCode());
        result = prime * result + ((getInvoiceNumber() == null) ? 0 : getInvoiceNumber().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getTargetAmount() == null) ? 0 : getTargetAmount().hashCode());
        result = prime * result + ((getTaxRate() == null) ? 0 : getTaxRate().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getTargetDiscount() == null) ? 0 : getTargetDiscount().hashCode());
        result = prime * result + ((getTargetRegion() == null) ? 0 : getTargetRegion().hashCode());
        result = prime * result + ((getActionType() == null) ? 0 : getActionType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getError() == null) ? 0 : getError().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", processCode=").append(processCode);
        sb.append(", invoiceNumber=").append(invoiceNumber);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", targetAmount=").append(targetAmount);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", currency=").append(currency);
        sb.append(", targetDiscount=").append(targetDiscount);
        sb.append(", targetRegion=").append(targetRegion);
        sb.append(", actionType=").append(actionType);
        sb.append(", status=").append(status);
        sb.append(", error=").append(error);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}