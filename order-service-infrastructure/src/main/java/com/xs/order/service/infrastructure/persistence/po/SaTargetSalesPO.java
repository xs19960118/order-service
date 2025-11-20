package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sa_target_sales
 */
@TableName(value ="sa_target_sales")
@Data
public class SaTargetSalesPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 活动编码
     */
    private String activityCode;

    /**
     * 活动对象编码
     */
    private String targetCode;

    /**
     * 销售ID
     */
    private Integer sales;

    /**
     * 绩效比例
     */
    private Double proportion;

    /**
     * 是否删除
     */
    private Integer deleted;

    /**
     * 分配病例个数
     */
    private Integer caseNum;

    /**
     * 类别:0:默认销售,1:绩效分配用
     */
    private Integer type;

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
        SaTargetSalesPO other = (SaTargetSalesPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityCode() == null ? other.getActivityCode() == null : this.getActivityCode().equals(other.getActivityCode()))
            && (this.getTargetCode() == null ? other.getTargetCode() == null : this.getTargetCode().equals(other.getTargetCode()))
            && (this.getSales() == null ? other.getSales() == null : this.getSales().equals(other.getSales()))
            && (this.getProportion() == null ? other.getProportion() == null : this.getProportion().equals(other.getProportion()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getCaseNum() == null ? other.getCaseNum() == null : this.getCaseNum().equals(other.getCaseNum()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityCode() == null) ? 0 : getActivityCode().hashCode());
        result = prime * result + ((getTargetCode() == null) ? 0 : getTargetCode().hashCode());
        result = prime * result + ((getSales() == null) ? 0 : getSales().hashCode());
        result = prime * result + ((getProportion() == null) ? 0 : getProportion().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getCaseNum() == null) ? 0 : getCaseNum().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
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
        sb.append(", targetCode=").append(targetCode);
        sb.append(", sales=").append(sales);
        sb.append(", proportion=").append(proportion);
        sb.append(", deleted=").append(deleted);
        sb.append(", caseNum=").append(caseNum);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}