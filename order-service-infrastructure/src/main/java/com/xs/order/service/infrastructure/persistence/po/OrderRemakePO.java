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
 * 病例重出设计记录表
 * @TableName order_remake
 */
@TableName(value ="order_remake")
@Data
public class OrderRemakePO implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 设计编号
     */
    private String designCode;

    /**
     * 病例编号
     */
    private String caseCode;

    /**
     * 当前阶段创建时间
     */
    private Long timeStage;

    /**
     * 重出流程是否包含设计费, 0.不包含 1.包含
     */
    private Integer includeDesignOrder;

    /**
     * 活动对象编号
     */
    private String targetCode;

    /**
     * 结算状态标志位, 1.已对账(中), 2.已卡票(中), 3.已核销(中)
     */
    private byte[] settlementBit;

    /**
     * 标记位, 1.重出
     */
    private byte[] labelBit;

    /**
     * 状态, 0.待处理 1.处理中 2.已完成 3.已取消
     */
    private Integer status;

    /**
     * 钉钉状态, 1.已发审批 2.已完成 3.已取消 10.无需发起
     */
    private Integer dingtalkStatus;

    /**
     * 钉钉审批流id
     */
    private String instanceId;

    /**
     * 乐观锁
     */
    private Integer version;

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
        OrderRemakePO other = (OrderRemakePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDesignCode() == null ? other.getDesignCode() == null : this.getDesignCode().equals(other.getDesignCode()))
            && (this.getCaseCode() == null ? other.getCaseCode() == null : this.getCaseCode().equals(other.getCaseCode()))
            && (this.getTimeStage() == null ? other.getTimeStage() == null : this.getTimeStage().equals(other.getTimeStage()))
            && (this.getIncludeDesignOrder() == null ? other.getIncludeDesignOrder() == null : this.getIncludeDesignOrder().equals(other.getIncludeDesignOrder()))
            && (this.getTargetCode() == null ? other.getTargetCode() == null : this.getTargetCode().equals(other.getTargetCode()))
            && (Arrays.equals(this.getSettlementBit(), other.getSettlementBit()))
            && (Arrays.equals(this.getLabelBit(), other.getLabelBit()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDingtalkStatus() == null ? other.getDingtalkStatus() == null : this.getDingtalkStatus().equals(other.getDingtalkStatus()))
            && (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getInstanceId()))
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
        result = prime * result + ((getDesignCode() == null) ? 0 : getDesignCode().hashCode());
        result = prime * result + ((getCaseCode() == null) ? 0 : getCaseCode().hashCode());
        result = prime * result + ((getTimeStage() == null) ? 0 : getTimeStage().hashCode());
        result = prime * result + ((getIncludeDesignOrder() == null) ? 0 : getIncludeDesignOrder().hashCode());
        result = prime * result + ((getTargetCode() == null) ? 0 : getTargetCode().hashCode());
        result = prime * result + (Arrays.hashCode(getSettlementBit()));
        result = prime * result + (Arrays.hashCode(getLabelBit()));
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDingtalkStatus() == null) ? 0 : getDingtalkStatus().hashCode());
        result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
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
        sb.append(", designCode=").append(designCode);
        sb.append(", caseCode=").append(caseCode);
        sb.append(", timeStage=").append(timeStage);
        sb.append(", includeDesignOrder=").append(includeDesignOrder);
        sb.append(", targetCode=").append(targetCode);
        sb.append(", settlementBit=").append(settlementBit);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", status=").append(status);
        sb.append(", dingtalkStatus=").append(dingtalkStatus);
        sb.append(", instanceId=").append(instanceId);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}