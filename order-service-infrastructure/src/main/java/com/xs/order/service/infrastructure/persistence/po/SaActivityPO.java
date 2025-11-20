package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动分类(sa: sales-activity)
 * @TableName sa_activity
 */
@TableName(value ="sa_activity")
@Data
public class SaActivityPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 活动名
     */
    private String name;

    /**
     * 活动编码
     */
    private String code;

    /**
     * 活动类型.1:固定病例价格,2:减免部分金额,3:折扣,4:预购,5:只打标不优惠,6:满赠/满减
     */
    private Integer activityType;

    /**
     * 活动类型明细, 1:指定病例价格 2:减免部分金额 3:折扣
     */
    private Integer activityTypeDetail;

    /**
     * 优惠类型, 是活动类型的细分
     */
    private Integer discountType;

    /**
     * 
     */
    private Integer activityNature;

    /**
     * 活动的优先级, 1: 预购, 999:其他 数字越小优先级越高
     */
    private String activitySort;

    /**
     * 事前病例参与活动的参照时间
     */
    private Integer caseJoinSort;

    /**
     * 
     */
    private Integer isCircle;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 状态: 0:新建 1:未生效 2:生效 3:失效
     */
    private Integer status;

    /**
     * 
     */
    private Integer deleted;

    /**
     * 优惠时机和优惠动作
     */
    private String actions;

    /**
     * 满减活动, 对优惠病例的行为
     */
    private String actionsGift;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Date deleteTime;

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
        SaActivityPO other = (SaActivityPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getActivityType() == null ? other.getActivityType() == null : this.getActivityType().equals(other.getActivityType()))
            && (this.getActivityTypeDetail() == null ? other.getActivityTypeDetail() == null : this.getActivityTypeDetail().equals(other.getActivityTypeDetail()))
            && (this.getDiscountType() == null ? other.getDiscountType() == null : this.getDiscountType().equals(other.getDiscountType()))
            && (this.getActivityNature() == null ? other.getActivityNature() == null : this.getActivityNature().equals(other.getActivityNature()))
            && (this.getActivitySort() == null ? other.getActivitySort() == null : this.getActivitySort().equals(other.getActivitySort()))
            && (this.getCaseJoinSort() == null ? other.getCaseJoinSort() == null : this.getCaseJoinSort().equals(other.getCaseJoinSort()))
            && (this.getIsCircle() == null ? other.getIsCircle() == null : this.getIsCircle().equals(other.getIsCircle()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getActions() == null ? other.getActions() == null : this.getActions().equals(other.getActions()))
            && (this.getActionsGift() == null ? other.getActionsGift() == null : this.getActionsGift().equals(other.getActionsGift()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getActivityType() == null) ? 0 : getActivityType().hashCode());
        result = prime * result + ((getActivityTypeDetail() == null) ? 0 : getActivityTypeDetail().hashCode());
        result = prime * result + ((getDiscountType() == null) ? 0 : getDiscountType().hashCode());
        result = prime * result + ((getActivityNature() == null) ? 0 : getActivityNature().hashCode());
        result = prime * result + ((getActivitySort() == null) ? 0 : getActivitySort().hashCode());
        result = prime * result + ((getCaseJoinSort() == null) ? 0 : getCaseJoinSort().hashCode());
        result = prime * result + ((getIsCircle() == null) ? 0 : getIsCircle().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getActions() == null) ? 0 : getActions().hashCode());
        result = prime * result + ((getActionsGift() == null) ? 0 : getActionsGift().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", activityType=").append(activityType);
        sb.append(", activityTypeDetail=").append(activityTypeDetail);
        sb.append(", discountType=").append(discountType);
        sb.append(", activityNature=").append(activityNature);
        sb.append(", activitySort=").append(activitySort);
        sb.append(", caseJoinSort=").append(caseJoinSort);
        sb.append(", isCircle=").append(isCircle);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", status=").append(status);
        sb.append(", deleted=").append(deleted);
        sb.append(", actions=").append(actions);
        sb.append(", actionsGift=").append(actionsGift);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}