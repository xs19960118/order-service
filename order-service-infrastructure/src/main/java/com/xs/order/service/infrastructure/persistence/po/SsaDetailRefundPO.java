package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动对象退费明细表
 * @TableName ssa_detail_refund
 */
@TableName(value ="ssa_detail_refund")
@Data
public class SsaDetailRefundPO implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 对象编号
     */
    private String targetCode;

    /**
     * 对象明细编号
     */
    private String detailCode;

    /**
     * 退款数量
     */
    private Long amountRefund;

    /**
     * 0.待处理， 1.处理中, 2.处理完成, 10.处理失败
     */
    private Integer status;

    /**
     * 触发退款时间
     */
    private Long timeRefunding;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 版本控制锁
     */
    private Long version;

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
        SsaDetailRefundPO other = (SsaDetailRefundPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTargetCode() == null ? other.getTargetCode() == null : this.getTargetCode().equals(other.getTargetCode()))
            && (this.getDetailCode() == null ? other.getDetailCode() == null : this.getDetailCode().equals(other.getDetailCode()))
            && (this.getAmountRefund() == null ? other.getAmountRefund() == null : this.getAmountRefund().equals(other.getAmountRefund()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTimeRefunding() == null ? other.getTimeRefunding() == null : this.getTimeRefunding().equals(other.getTimeRefunding()))
            && (this.getError() == null ? other.getError() == null : this.getError().equals(other.getError()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTargetCode() == null) ? 0 : getTargetCode().hashCode());
        result = prime * result + ((getDetailCode() == null) ? 0 : getDetailCode().hashCode());
        result = prime * result + ((getAmountRefund() == null) ? 0 : getAmountRefund().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTimeRefunding() == null) ? 0 : getTimeRefunding().hashCode());
        result = prime * result + ((getError() == null) ? 0 : getError().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
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
        sb.append(", targetCode=").append(targetCode);
        sb.append(", detailCode=").append(detailCode);
        sb.append(", amountRefund=").append(amountRefund);
        sb.append(", status=").append(status);
        sb.append(", timeRefunding=").append(timeRefunding);
        sb.append(", error=").append(error);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}