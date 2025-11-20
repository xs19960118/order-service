package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ssa对象明细
 * @TableName ssa_process_binds
 */
@TableName(value ="ssa_process_binds")
@Data
public class SsaProcessBindsPO implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 活动编码
     */
    private String promotionCode;

    /**
     * 对象编码
     */
    private String targetCode;

    /**
     * 明细编码
     */
    private String detailCode;

    /**
     * 单据编码
     */
    private String processCode;

    /**
     * 病例阶段时间
     */
    private Long timeStage;

    /**
     * 绑定状态， 0.未绑定，1.已绑定
     */
    private Integer state;

    /**
     * 解绑时间
     */
    private Long timeUnbind;

    /**
     * 修改人
     */
    private Integer createUid;

    /**
     * 修改人
     */
    private Integer modifyUid;

    /**
     * 版本控制锁
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
        SsaProcessBindsPO other = (SsaProcessBindsPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPromotionCode() == null ? other.getPromotionCode() == null : this.getPromotionCode().equals(other.getPromotionCode()))
            && (this.getTargetCode() == null ? other.getTargetCode() == null : this.getTargetCode().equals(other.getTargetCode()))
            && (this.getDetailCode() == null ? other.getDetailCode() == null : this.getDetailCode().equals(other.getDetailCode()))
            && (this.getProcessCode() == null ? other.getProcessCode() == null : this.getProcessCode().equals(other.getProcessCode()))
            && (this.getTimeStage() == null ? other.getTimeStage() == null : this.getTimeStage().equals(other.getTimeStage()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getTimeUnbind() == null ? other.getTimeUnbind() == null : this.getTimeUnbind().equals(other.getTimeUnbind()))
            && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid().equals(other.getCreateUid()))
            && (this.getModifyUid() == null ? other.getModifyUid() == null : this.getModifyUid().equals(other.getModifyUid()))
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
        result = prime * result + ((getPromotionCode() == null) ? 0 : getPromotionCode().hashCode());
        result = prime * result + ((getTargetCode() == null) ? 0 : getTargetCode().hashCode());
        result = prime * result + ((getDetailCode() == null) ? 0 : getDetailCode().hashCode());
        result = prime * result + ((getProcessCode() == null) ? 0 : getProcessCode().hashCode());
        result = prime * result + ((getTimeStage() == null) ? 0 : getTimeStage().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getTimeUnbind() == null) ? 0 : getTimeUnbind().hashCode());
        result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
        result = prime * result + ((getModifyUid() == null) ? 0 : getModifyUid().hashCode());
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
        sb.append(", promotionCode=").append(promotionCode);
        sb.append(", targetCode=").append(targetCode);
        sb.append(", detailCode=").append(detailCode);
        sb.append(", processCode=").append(processCode);
        sb.append(", timeStage=").append(timeStage);
        sb.append(", state=").append(state);
        sb.append(", timeUnbind=").append(timeUnbind);
        sb.append(", createUid=").append(createUid);
        sb.append(", modifyUid=").append(modifyUid);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}