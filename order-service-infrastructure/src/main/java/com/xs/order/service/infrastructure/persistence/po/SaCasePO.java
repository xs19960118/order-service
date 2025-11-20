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
 * 参与活动的病例
 * @TableName sa_case
 */
@TableName(value ="sa_case")
@Data
public class SaCasePO implements Serializable {
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
     * 
     */
    private Integer targetDetailId;

    /**
     * 被优惠的病例编号
     */
    private String caseCode;

    /**
     * 打包优惠的分组id
     */
    private Integer casePackageId;

    /**
     * 病例是累计的, 还是最终优惠的那个: 1: 普通优惠病例 2: 累计但不优惠 3:满赠或满减优惠病例
     */
    private Integer caseType;

    /**
     * 状态: 0:新建/已打标 1:只打标不优惠 2:已打标已优惠
     */
    private Integer status;

    /**
     * 异常信息: 0:无异常  1:优惠失败
     */
    private Integer exception;

    /**
     * 是否忽略: 0: 否, 1:是
     */
    private Integer ignored;

    /**
     * 绑定途径: 0: 系统绑定, 1:手工绑定 2:事前病例绑定
     */
    private Integer manualBind;

    /**
     * 是否预绑定 0: 否 1: 是
     */
    private Integer isPreBind;

    /**
     * 
     */
    private String groupCode;

    /**
     * 
     */
    private String accountCode;

    /**
     * 
     */
    private String doctorCode;

    /**
     * 
     */
    private String patientCode;

    /**
     * 
     */
    private String productCode;

    /**
     * 梯度表id
     */
    private Integer gradientId;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 是否删除/解绑:  1: 是 0: 否
     */
    private Integer deleted;

    /**
     * 关联病例时病例附属信息
     */
    private String remark;

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

    /**
     * 活动价格
     */
    private BigDecimal price;

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
        SaCasePO other = (SaCasePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityCode() == null ? other.getActivityCode() == null : this.getActivityCode().equals(other.getActivityCode()))
            && (this.getTargetCode() == null ? other.getTargetCode() == null : this.getTargetCode().equals(other.getTargetCode()))
            && (this.getTargetDetailId() == null ? other.getTargetDetailId() == null : this.getTargetDetailId().equals(other.getTargetDetailId()))
            && (this.getCaseCode() == null ? other.getCaseCode() == null : this.getCaseCode().equals(other.getCaseCode()))
            && (this.getCasePackageId() == null ? other.getCasePackageId() == null : this.getCasePackageId().equals(other.getCasePackageId()))
            && (this.getCaseType() == null ? other.getCaseType() == null : this.getCaseType().equals(other.getCaseType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getException() == null ? other.getException() == null : this.getException().equals(other.getException()))
            && (this.getIgnored() == null ? other.getIgnored() == null : this.getIgnored().equals(other.getIgnored()))
            && (this.getManualBind() == null ? other.getManualBind() == null : this.getManualBind().equals(other.getManualBind()))
            && (this.getIsPreBind() == null ? other.getIsPreBind() == null : this.getIsPreBind().equals(other.getIsPreBind()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()))
            && (this.getAccountCode() == null ? other.getAccountCode() == null : this.getAccountCode().equals(other.getAccountCode()))
            && (this.getDoctorCode() == null ? other.getDoctorCode() == null : this.getDoctorCode().equals(other.getDoctorCode()))
            && (this.getPatientCode() == null ? other.getPatientCode() == null : this.getPatientCode().equals(other.getPatientCode()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getGradientId() == null ? other.getGradientId() == null : this.getGradientId().equals(other.getGradientId()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityCode() == null) ? 0 : getActivityCode().hashCode());
        result = prime * result + ((getTargetCode() == null) ? 0 : getTargetCode().hashCode());
        result = prime * result + ((getTargetDetailId() == null) ? 0 : getTargetDetailId().hashCode());
        result = prime * result + ((getCaseCode() == null) ? 0 : getCaseCode().hashCode());
        result = prime * result + ((getCasePackageId() == null) ? 0 : getCasePackageId().hashCode());
        result = prime * result + ((getCaseType() == null) ? 0 : getCaseType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getException() == null) ? 0 : getException().hashCode());
        result = prime * result + ((getIgnored() == null) ? 0 : getIgnored().hashCode());
        result = prime * result + ((getManualBind() == null) ? 0 : getManualBind().hashCode());
        result = prime * result + ((getIsPreBind() == null) ? 0 : getIsPreBind().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        result = prime * result + ((getAccountCode() == null) ? 0 : getAccountCode().hashCode());
        result = prime * result + ((getDoctorCode() == null) ? 0 : getDoctorCode().hashCode());
        result = prime * result + ((getPatientCode() == null) ? 0 : getPatientCode().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getGradientId() == null) ? 0 : getGradientId().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
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
        sb.append(", caseCode=").append(caseCode);
        sb.append(", casePackageId=").append(casePackageId);
        sb.append(", caseType=").append(caseType);
        sb.append(", status=").append(status);
        sb.append(", exception=").append(exception);
        sb.append(", ignored=").append(ignored);
        sb.append(", manualBind=").append(manualBind);
        sb.append(", isPreBind=").append(isPreBind);
        sb.append(", groupCode=").append(groupCode);
        sb.append(", accountCode=").append(accountCode);
        sb.append(", doctorCode=").append(doctorCode);
        sb.append(", patientCode=").append(patientCode);
        sb.append(", productCode=").append(productCode);
        sb.append(", gradientId=").append(gradientId);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", deleted=").append(deleted);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}