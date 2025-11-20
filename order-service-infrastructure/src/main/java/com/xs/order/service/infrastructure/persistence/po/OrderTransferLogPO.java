package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName order_transfer_log
 */
@TableName(value ="order_transfer_log")
@Data
public class OrderTransferLogPO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 转移类型， 1.转机构
     */
    private Integer transferType;

    /**
     * 来源订单号
     */
    private String orderCodeFrom;

    /**
     * 目标订单号
     */
    private String orderCodeTo;

    /**
     * 创建时间
     */
    private Date createTime;

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
        OrderTransferLogPO other = (OrderTransferLogPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTransferType() == null ? other.getTransferType() == null : this.getTransferType().equals(other.getTransferType()))
            && (this.getOrderCodeFrom() == null ? other.getOrderCodeFrom() == null : this.getOrderCodeFrom().equals(other.getOrderCodeFrom()))
            && (this.getOrderCodeTo() == null ? other.getOrderCodeTo() == null : this.getOrderCodeTo().equals(other.getOrderCodeTo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTransferType() == null) ? 0 : getTransferType().hashCode());
        result = prime * result + ((getOrderCodeFrom() == null) ? 0 : getOrderCodeFrom().hashCode());
        result = prime * result + ((getOrderCodeTo() == null) ? 0 : getOrderCodeTo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", transferType=").append(transferType);
        sb.append(", orderCodeFrom=").append(orderCodeFrom);
        sb.append(", orderCodeTo=").append(orderCodeTo);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}