package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 参与活动的病例分组表
 * @TableName sa_case_package
 */
@TableName(value ="sa_case_package")
@Data
public class SaCasePackagePO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 活动id
     */
    private String activityCode;

    /**
     * 活动对象记录表id
     */
    private String targetCode;

    /**
     * 活动对象详情
     */
    private Integer targetDetailId;

    /**
     * 最大病例数
     */
    private Integer maxCaseNum;

    /**
     * 累计病例的数量
     */
    private Integer caseNum;

    /**
     * 创建时时间
     */
    private Date createTime;

    /**
     * 
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
        SaCasePackagePO other = (SaCasePackagePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityCode() == null ? other.getActivityCode() == null : this.getActivityCode().equals(other.getActivityCode()))
            && (this.getTargetCode() == null ? other.getTargetCode() == null : this.getTargetCode().equals(other.getTargetCode()))
            && (this.getTargetDetailId() == null ? other.getTargetDetailId() == null : this.getTargetDetailId().equals(other.getTargetDetailId()))
            && (this.getMaxCaseNum() == null ? other.getMaxCaseNum() == null : this.getMaxCaseNum().equals(other.getMaxCaseNum()))
            && (this.getCaseNum() == null ? other.getCaseNum() == null : this.getCaseNum().equals(other.getCaseNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityCode() == null) ? 0 : getActivityCode().hashCode());
        result = prime * result + ((getTargetCode() == null) ? 0 : getTargetCode().hashCode());
        result = prime * result + ((getTargetDetailId() == null) ? 0 : getTargetDetailId().hashCode());
        result = prime * result + ((getMaxCaseNum() == null) ? 0 : getMaxCaseNum().hashCode());
        result = prime * result + ((getCaseNum() == null) ? 0 : getCaseNum().hashCode());
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
        sb.append(", targetCode=").append(targetCode);
        sb.append(", targetDetailId=").append(targetDetailId);
        sb.append(", maxCaseNum=").append(maxCaseNum);
        sb.append(", caseNum=").append(caseNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}