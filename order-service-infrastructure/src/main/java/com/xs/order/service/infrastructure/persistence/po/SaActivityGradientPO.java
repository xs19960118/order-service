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
 * 梯度规则表,某段时间内,上一步绑定的病例数量, 当前第x个病例,价格是多少
 * @TableName sa_activity_gradient
 */
@TableName(value ="sa_activity_gradient")
@Data
public class SaActivityGradientPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 活动管理编码
     */
    private String activityCode;

    /**
     * 步骤
     */
    private Integer step;

    /**
     * 累计方法: 0:仅累计上一步的病例 1:累计上边所有步数的病例 2:之前任意阶段
     */
    private String counterType;

    /**
     * 开始时间/相对开始天数
     */
    private String startDay;

    /**
     * 截止时间/相对截止天数, 如活动开始后90天
     */
    private String endDay;

    /**
     * 上一步累计病例数量,最小值, 0表示不限制
     */
    private Integer preCounterStart;

    /**
     * 上一步累计病例数量,最大值, 0表示不限制
     */
    private Integer preCounterEnd;

    /**
     * 从第x个病例开始享受活动
     */
    private Integer discountNumStart;

    /**
     * 第y个病例后不再享受活动
     */
    private Integer discountNumEnd;

    /**
     * 活动价格
     */
    private BigDecimal price;

    /**
     * 是否删除
     */
    private Integer deleted;

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
        SaActivityGradientPO other = (SaActivityGradientPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityCode() == null ? other.getActivityCode() == null : this.getActivityCode().equals(other.getActivityCode()))
            && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
            && (this.getCounterType() == null ? other.getCounterType() == null : this.getCounterType().equals(other.getCounterType()))
            && (this.getStartDay() == null ? other.getStartDay() == null : this.getStartDay().equals(other.getStartDay()))
            && (this.getEndDay() == null ? other.getEndDay() == null : this.getEndDay().equals(other.getEndDay()))
            && (this.getPreCounterStart() == null ? other.getPreCounterStart() == null : this.getPreCounterStart().equals(other.getPreCounterStart()))
            && (this.getPreCounterEnd() == null ? other.getPreCounterEnd() == null : this.getPreCounterEnd().equals(other.getPreCounterEnd()))
            && (this.getDiscountNumStart() == null ? other.getDiscountNumStart() == null : this.getDiscountNumStart().equals(other.getDiscountNumStart()))
            && (this.getDiscountNumEnd() == null ? other.getDiscountNumEnd() == null : this.getDiscountNumEnd().equals(other.getDiscountNumEnd()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityCode() == null) ? 0 : getActivityCode().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getCounterType() == null) ? 0 : getCounterType().hashCode());
        result = prime * result + ((getStartDay() == null) ? 0 : getStartDay().hashCode());
        result = prime * result + ((getEndDay() == null) ? 0 : getEndDay().hashCode());
        result = prime * result + ((getPreCounterStart() == null) ? 0 : getPreCounterStart().hashCode());
        result = prime * result + ((getPreCounterEnd() == null) ? 0 : getPreCounterEnd().hashCode());
        result = prime * result + ((getDiscountNumStart() == null) ? 0 : getDiscountNumStart().hashCode());
        result = prime * result + ((getDiscountNumEnd() == null) ? 0 : getDiscountNumEnd().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
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
        sb.append(", activityCode=").append(activityCode);
        sb.append(", step=").append(step);
        sb.append(", counterType=").append(counterType);
        sb.append(", startDay=").append(startDay);
        sb.append(", endDay=").append(endDay);
        sb.append(", preCounterStart=").append(preCounterStart);
        sb.append(", preCounterEnd=").append(preCounterEnd);
        sb.append(", discountNumStart=").append(discountNumStart);
        sb.append(", discountNumEnd=").append(discountNumEnd);
        sb.append(", price=").append(price);
        sb.append(", deleted=").append(deleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}