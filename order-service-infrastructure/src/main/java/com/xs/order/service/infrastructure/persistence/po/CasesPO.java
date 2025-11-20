package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 主数据-病例
 * @TableName cases
 */
@TableName(value ="cases")
@Data
public class CasesPO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 病例编号
     */
    private String code;

    /**
     * 产品编号
     */
    private String productCode;

    /**
     * 患者编号
     */
    private String patientCode;

    /**
     * 医生编号
     */
    private String doctorCode;

    /**
     * 机构编号
     */
    private String hospitalCode;

    /**
     * 代理商编号
     */
    private String groupCode;

    /**
     * 首次排产医生编号
     */
    private String productionDoctorCode;

    /**
     * 病例第一次确认的冠军版设计编码
     */
    private String proDesignCode;

    /**
     * 进设计时间
     */
    private Long timeDesign;

    /**
     * 排产时间
     */
    private Long timeProduction;

    /**
     * 病例第一次确认的关娟板设计对应的阶段时间戳，0表示新病例阶段
     */
    private Long proTimeStage;

    /**
     * 病例bit, 1.病例处理附属订单标识
     */
    private Integer labelBit;

    /**
     * 事件投递时间
     */
    private Long timeAction;

    /**
     * 版本号
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

    /**
     * BA编号
     */
    private String baCode;

    /**
     * 病例首次3D设计确认时间戳
     */
    private Long firstTimeDesignConfirm;

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
        CasesPO other = (CasesPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getPatientCode() == null ? other.getPatientCode() == null : this.getPatientCode().equals(other.getPatientCode()))
            && (this.getDoctorCode() == null ? other.getDoctorCode() == null : this.getDoctorCode().equals(other.getDoctorCode()))
            && (this.getHospitalCode() == null ? other.getHospitalCode() == null : this.getHospitalCode().equals(other.getHospitalCode()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()))
            && (this.getProductionDoctorCode() == null ? other.getProductionDoctorCode() == null : this.getProductionDoctorCode().equals(other.getProductionDoctorCode()))
            && (this.getProDesignCode() == null ? other.getProDesignCode() == null : this.getProDesignCode().equals(other.getProDesignCode()))
            && (this.getTimeDesign() == null ? other.getTimeDesign() == null : this.getTimeDesign().equals(other.getTimeDesign()))
            && (this.getTimeProduction() == null ? other.getTimeProduction() == null : this.getTimeProduction().equals(other.getTimeProduction()))
            && (this.getProTimeStage() == null ? other.getProTimeStage() == null : this.getProTimeStage().equals(other.getProTimeStage()))
            && (this.getLabelBit() == null ? other.getLabelBit() == null : this.getLabelBit().equals(other.getLabelBit()))
            && (this.getTimeAction() == null ? other.getTimeAction() == null : this.getTimeAction().equals(other.getTimeAction()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getBaCode() == null ? other.getBaCode() == null : this.getBaCode().equals(other.getBaCode()))
            && (this.getFirstTimeDesignConfirm() == null ? other.getFirstTimeDesignConfirm() == null : this.getFirstTimeDesignConfirm().equals(other.getFirstTimeDesignConfirm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getPatientCode() == null) ? 0 : getPatientCode().hashCode());
        result = prime * result + ((getDoctorCode() == null) ? 0 : getDoctorCode().hashCode());
        result = prime * result + ((getHospitalCode() == null) ? 0 : getHospitalCode().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        result = prime * result + ((getProductionDoctorCode() == null) ? 0 : getProductionDoctorCode().hashCode());
        result = prime * result + ((getProDesignCode() == null) ? 0 : getProDesignCode().hashCode());
        result = prime * result + ((getTimeDesign() == null) ? 0 : getTimeDesign().hashCode());
        result = prime * result + ((getTimeProduction() == null) ? 0 : getTimeProduction().hashCode());
        result = prime * result + ((getProTimeStage() == null) ? 0 : getProTimeStage().hashCode());
        result = prime * result + ((getLabelBit() == null) ? 0 : getLabelBit().hashCode());
        result = prime * result + ((getTimeAction() == null) ? 0 : getTimeAction().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getBaCode() == null) ? 0 : getBaCode().hashCode());
        result = prime * result + ((getFirstTimeDesignConfirm() == null) ? 0 : getFirstTimeDesignConfirm().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", productCode=").append(productCode);
        sb.append(", patientCode=").append(patientCode);
        sb.append(", doctorCode=").append(doctorCode);
        sb.append(", hospitalCode=").append(hospitalCode);
        sb.append(", groupCode=").append(groupCode);
        sb.append(", productionDoctorCode=").append(productionDoctorCode);
        sb.append(", proDesignCode=").append(proDesignCode);
        sb.append(", timeDesign=").append(timeDesign);
        sb.append(", timeProduction=").append(timeProduction);
        sb.append(", proTimeStage=").append(proTimeStage);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", timeAction=").append(timeAction);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", baCode=").append(baCode);
        sb.append(", firstTimeDesignConfirm=").append(firstTimeDesignConfirm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}