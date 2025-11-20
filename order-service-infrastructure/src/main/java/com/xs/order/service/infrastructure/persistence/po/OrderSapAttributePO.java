package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import lombok.Data;

/**
 * SAP扩展表
 * @TableName order_sap_attribute
 */
@TableName(value ="order_sap_attribute")
@Data
public class OrderSapAttributePO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 调整原因, 活动/合同/手工
     */
    private String reasonAdjustment;

    /**
     * 重压原因: 1.矫治器原因, 2.客服重压, 3.临床要求, 4.患者原因
     */
    private Integer reasonRemanufactured;

    /**
     * 订单来源， 1.生产加工单, 2.升档
     */
    private Integer orderSource;

    /**
     * 业务编码
     */
    private String processCode;

    /**
     * 业务编码类型 1.病例， 2.业务单据， 2.销售单据
     */
    private Integer processCodeType;

    /**
     * 病例附属订单关联的主订单编号
     */
    private String caseOrderCode;

    /**
     * fsm系统变更产品来源订单
     */
    private String upgradedFrom;

    /**
     * 订单状态变更的时间戳
     */
    private Integer timeStatusChange;

    /**
     * 特殊标签， 1.是否退换货， 2.生产加工单补的0元订单
     */
    private byte[] labelBit;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Long deleteTime;

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
        OrderSapAttributePO other = (OrderSapAttributePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getReasonAdjustment() == null ? other.getReasonAdjustment() == null : this.getReasonAdjustment().equals(other.getReasonAdjustment()))
            && (this.getReasonRemanufactured() == null ? other.getReasonRemanufactured() == null : this.getReasonRemanufactured().equals(other.getReasonRemanufactured()))
            && (this.getOrderSource() == null ? other.getOrderSource() == null : this.getOrderSource().equals(other.getOrderSource()))
            && (this.getProcessCode() == null ? other.getProcessCode() == null : this.getProcessCode().equals(other.getProcessCode()))
            && (this.getProcessCodeType() == null ? other.getProcessCodeType() == null : this.getProcessCodeType().equals(other.getProcessCodeType()))
            && (this.getCaseOrderCode() == null ? other.getCaseOrderCode() == null : this.getCaseOrderCode().equals(other.getCaseOrderCode()))
            && (this.getUpgradedFrom() == null ? other.getUpgradedFrom() == null : this.getUpgradedFrom().equals(other.getUpgradedFrom()))
            && (this.getTimeStatusChange() == null ? other.getTimeStatusChange() == null : this.getTimeStatusChange().equals(other.getTimeStatusChange()))
            && (Arrays.equals(this.getLabelBit(), other.getLabelBit()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getReasonAdjustment() == null) ? 0 : getReasonAdjustment().hashCode());
        result = prime * result + ((getReasonRemanufactured() == null) ? 0 : getReasonRemanufactured().hashCode());
        result = prime * result + ((getOrderSource() == null) ? 0 : getOrderSource().hashCode());
        result = prime * result + ((getProcessCode() == null) ? 0 : getProcessCode().hashCode());
        result = prime * result + ((getProcessCodeType() == null) ? 0 : getProcessCodeType().hashCode());
        result = prime * result + ((getCaseOrderCode() == null) ? 0 : getCaseOrderCode().hashCode());
        result = prime * result + ((getUpgradedFrom() == null) ? 0 : getUpgradedFrom().hashCode());
        result = prime * result + ((getTimeStatusChange() == null) ? 0 : getTimeStatusChange().hashCode());
        result = prime * result + (Arrays.hashCode(getLabelBit()));
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", reasonAdjustment=").append(reasonAdjustment);
        sb.append(", reasonRemanufactured=").append(reasonRemanufactured);
        sb.append(", orderSource=").append(orderSource);
        sb.append(", processCode=").append(processCode);
        sb.append(", processCodeType=").append(processCodeType);
        sb.append(", caseOrderCode=").append(caseOrderCode);
        sb.append(", upgradedFrom=").append(upgradedFrom);
        sb.append(", timeStatusChange=").append(timeStatusChange);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}