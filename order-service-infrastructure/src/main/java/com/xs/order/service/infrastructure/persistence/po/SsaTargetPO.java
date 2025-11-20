package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ssa对象
 * @TableName ssa_target
 */
@TableName(value ="ssa_target")
@Data
public class SsaTargetPO implements Serializable {
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
    private String code;

    /**
     * 活动对象开始时间
     */
    private Date datetimeStart;

    /**
     * 活动对象开始时间
     */
    private Date datetimeEnd;

    /**
     * 总数量， null表示不限制
     */
    private Integer amountTotal;

    /**
     * 生效数量
     */
    private Integer actualTotal;

    /**
     * 已使用数量
     */
    private Integer amountUsed;

    /**
     * 时区
     */
    private String timezone;

    /**
     * 备注
     */
    private String note;

    /**
     * 状态， 0.待生效，1.已生效，10.失效, 11.已过期
     */
    private Integer status;

    /**
     * 审核状态
     */
    private Integer validationStatus;

    /**
     * bit标签
     */
    private Long labelBit;

    /**
     * 负责人id
     */
    private Integer assignUid;

    /**
     * 电销负责人id
     */
    private Integer ownerId;

    /**
     * 创建人
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
        SsaTargetPO other = (SsaTargetPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPromotionCode() == null ? other.getPromotionCode() == null : this.getPromotionCode().equals(other.getPromotionCode()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getDatetimeStart() == null ? other.getDatetimeStart() == null : this.getDatetimeStart().equals(other.getDatetimeStart()))
            && (this.getDatetimeEnd() == null ? other.getDatetimeEnd() == null : this.getDatetimeEnd().equals(other.getDatetimeEnd()))
            && (this.getAmountTotal() == null ? other.getAmountTotal() == null : this.getAmountTotal().equals(other.getAmountTotal()))
            && (this.getActualTotal() == null ? other.getActualTotal() == null : this.getActualTotal().equals(other.getActualTotal()))
            && (this.getAmountUsed() == null ? other.getAmountUsed() == null : this.getAmountUsed().equals(other.getAmountUsed()))
            && (this.getTimezone() == null ? other.getTimezone() == null : this.getTimezone().equals(other.getTimezone()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getValidationStatus() == null ? other.getValidationStatus() == null : this.getValidationStatus().equals(other.getValidationStatus()))
            && (this.getLabelBit() == null ? other.getLabelBit() == null : this.getLabelBit().equals(other.getLabelBit()))
            && (this.getAssignUid() == null ? other.getAssignUid() == null : this.getAssignUid().equals(other.getAssignUid()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
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
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getDatetimeStart() == null) ? 0 : getDatetimeStart().hashCode());
        result = prime * result + ((getDatetimeEnd() == null) ? 0 : getDatetimeEnd().hashCode());
        result = prime * result + ((getAmountTotal() == null) ? 0 : getAmountTotal().hashCode());
        result = prime * result + ((getActualTotal() == null) ? 0 : getActualTotal().hashCode());
        result = prime * result + ((getAmountUsed() == null) ? 0 : getAmountUsed().hashCode());
        result = prime * result + ((getTimezone() == null) ? 0 : getTimezone().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getValidationStatus() == null) ? 0 : getValidationStatus().hashCode());
        result = prime * result + ((getLabelBit() == null) ? 0 : getLabelBit().hashCode());
        result = prime * result + ((getAssignUid() == null) ? 0 : getAssignUid().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
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
        sb.append(", code=").append(code);
        sb.append(", datetimeStart=").append(datetimeStart);
        sb.append(", datetimeEnd=").append(datetimeEnd);
        sb.append(", amountTotal=").append(amountTotal);
        sb.append(", actualTotal=").append(actualTotal);
        sb.append(", amountUsed=").append(amountUsed);
        sb.append(", timezone=").append(timezone);
        sb.append(", note=").append(note);
        sb.append(", status=").append(status);
        sb.append(", validationStatus=").append(validationStatus);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", assignUid=").append(assignUid);
        sb.append(", ownerId=").append(ownerId);
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