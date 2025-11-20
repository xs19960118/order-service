package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动对象明细
 * @TableName sa_target_detail
 */
@TableName(value ="sa_target_detail")
@Data
public class SaTargetDetailPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String activityCode;

    /**
     * 活动对象编码
     */
    private String targetCode;

    /**
     * 集团编码
     */
    private String groupCode;

    /**
     * 经销商编码
     */
    private String agentCode;

    /**
     * 机构编码
     */
    private String accountCode;

    /**
     * 医生编码
     */
    private String doctorCode;

    /**
     * 病例编码
     */
    private String caseCode;

    /**
     * 分配的病例数量 0:表示不限
     */
    private Integer caseNum;

    /**
     * 满减病例数量
     */
    private Integer caseNumGift;

    /**
     * 
     */
    private Integer deleted;

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
     * BA账户编码
     */
    private String baCode;

    /**
     * 预计病例达成数量
     */
    private Integer predictCaseNum;

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
        SaTargetDetailPO other = (SaTargetDetailPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityCode() == null ? other.getActivityCode() == null : this.getActivityCode().equals(other.getActivityCode()))
            && (this.getTargetCode() == null ? other.getTargetCode() == null : this.getTargetCode().equals(other.getTargetCode()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()))
            && (this.getAgentCode() == null ? other.getAgentCode() == null : this.getAgentCode().equals(other.getAgentCode()))
            && (this.getAccountCode() == null ? other.getAccountCode() == null : this.getAccountCode().equals(other.getAccountCode()))
            && (this.getDoctorCode() == null ? other.getDoctorCode() == null : this.getDoctorCode().equals(other.getDoctorCode()))
            && (this.getCaseCode() == null ? other.getCaseCode() == null : this.getCaseCode().equals(other.getCaseCode()))
            && (this.getCaseNum() == null ? other.getCaseNum() == null : this.getCaseNum().equals(other.getCaseNum()))
            && (this.getCaseNumGift() == null ? other.getCaseNumGift() == null : this.getCaseNumGift().equals(other.getCaseNumGift()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getBaCode() == null ? other.getBaCode() == null : this.getBaCode().equals(other.getBaCode()))
            && (this.getPredictCaseNum() == null ? other.getPredictCaseNum() == null : this.getPredictCaseNum().equals(other.getPredictCaseNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityCode() == null) ? 0 : getActivityCode().hashCode());
        result = prime * result + ((getTargetCode() == null) ? 0 : getTargetCode().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        result = prime * result + ((getAgentCode() == null) ? 0 : getAgentCode().hashCode());
        result = prime * result + ((getAccountCode() == null) ? 0 : getAccountCode().hashCode());
        result = prime * result + ((getDoctorCode() == null) ? 0 : getDoctorCode().hashCode());
        result = prime * result + ((getCaseCode() == null) ? 0 : getCaseCode().hashCode());
        result = prime * result + ((getCaseNum() == null) ? 0 : getCaseNum().hashCode());
        result = prime * result + ((getCaseNumGift() == null) ? 0 : getCaseNumGift().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getBaCode() == null) ? 0 : getBaCode().hashCode());
        result = prime * result + ((getPredictCaseNum() == null) ? 0 : getPredictCaseNum().hashCode());
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
        sb.append(", groupCode=").append(groupCode);
        sb.append(", agentCode=").append(agentCode);
        sb.append(", accountCode=").append(accountCode);
        sb.append(", doctorCode=").append(doctorCode);
        sb.append(", caseCode=").append(caseCode);
        sb.append(", caseNum=").append(caseNum);
        sb.append(", caseNumGift=").append(caseNumGift);
        sb.append(", deleted=").append(deleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", baCode=").append(baCode);
        sb.append(", predictCaseNum=").append(predictCaseNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}