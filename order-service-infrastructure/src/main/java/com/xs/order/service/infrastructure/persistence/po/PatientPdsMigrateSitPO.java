package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 患者迁移pds数据
 * @TableName patient_pds_migrate_sit
 */
@TableName(value ="patient_pds_migrate_sit")
@Data
public class PatientPdsMigrateSitPO implements Serializable {
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 患者的CRM ID
     */
    private String crmId;

    /**
     * 患者在CRM的code
     */
    private String crmCode;

    /**
     * 患者国家二位编号
     */
    private String countryCode;

    /**
     * pds_code
     */
    private String pdsCode;

    /**
     * 姓名脱敏文
     */
    private String nameDesensitized;

    /**
     * 姓名hash
     */
    private String nameHash;

    /**
     * 性别原文枚举
     */
    private String genderC;

    /**
     * 性别脱敏文
     */
    private String genderCDesensitized;

    /**
     * 性别hash
     */
    private String genderCHash;

    /**
     * 出生日期脱敏文
     */
    private String birthdayCDesensitized;

    /**
     * 出生日期hash
     */
    private String birthdayCHash;

    /**
     * 移动电话（一）脱敏文
     */
    private String phoneMobileCDesensitized;

    /**
     * 移动电话（一）hash
     */
    private String phoneMobileCHash;

    /**
     * 创建时间
     */
    private Date dateCreated;

    /**
     * 修改时间
     */
    private Date dateModified;

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
        PatientPdsMigrateSitPO other = (PatientPdsMigrateSitPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCrmId() == null ? other.getCrmId() == null : this.getCrmId().equals(other.getCrmId()))
            && (this.getCrmCode() == null ? other.getCrmCode() == null : this.getCrmCode().equals(other.getCrmCode()))
            && (this.getCountryCode() == null ? other.getCountryCode() == null : this.getCountryCode().equals(other.getCountryCode()))
            && (this.getPdsCode() == null ? other.getPdsCode() == null : this.getPdsCode().equals(other.getPdsCode()))
            && (this.getNameDesensitized() == null ? other.getNameDesensitized() == null : this.getNameDesensitized().equals(other.getNameDesensitized()))
            && (this.getNameHash() == null ? other.getNameHash() == null : this.getNameHash().equals(other.getNameHash()))
            && (this.getGenderC() == null ? other.getGenderC() == null : this.getGenderC().equals(other.getGenderC()))
            && (this.getGenderCDesensitized() == null ? other.getGenderCDesensitized() == null : this.getGenderCDesensitized().equals(other.getGenderCDesensitized()))
            && (this.getGenderCHash() == null ? other.getGenderCHash() == null : this.getGenderCHash().equals(other.getGenderCHash()))
            && (this.getBirthdayCDesensitized() == null ? other.getBirthdayCDesensitized() == null : this.getBirthdayCDesensitized().equals(other.getBirthdayCDesensitized()))
            && (this.getBirthdayCHash() == null ? other.getBirthdayCHash() == null : this.getBirthdayCHash().equals(other.getBirthdayCHash()))
            && (this.getPhoneMobileCDesensitized() == null ? other.getPhoneMobileCDesensitized() == null : this.getPhoneMobileCDesensitized().equals(other.getPhoneMobileCDesensitized()))
            && (this.getPhoneMobileCHash() == null ? other.getPhoneMobileCHash() == null : this.getPhoneMobileCHash().equals(other.getPhoneMobileCHash()))
            && (this.getDateCreated() == null ? other.getDateCreated() == null : this.getDateCreated().equals(other.getDateCreated()))
            && (this.getDateModified() == null ? other.getDateModified() == null : this.getDateModified().equals(other.getDateModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCrmId() == null) ? 0 : getCrmId().hashCode());
        result = prime * result + ((getCrmCode() == null) ? 0 : getCrmCode().hashCode());
        result = prime * result + ((getCountryCode() == null) ? 0 : getCountryCode().hashCode());
        result = prime * result + ((getPdsCode() == null) ? 0 : getPdsCode().hashCode());
        result = prime * result + ((getNameDesensitized() == null) ? 0 : getNameDesensitized().hashCode());
        result = prime * result + ((getNameHash() == null) ? 0 : getNameHash().hashCode());
        result = prime * result + ((getGenderC() == null) ? 0 : getGenderC().hashCode());
        result = prime * result + ((getGenderCDesensitized() == null) ? 0 : getGenderCDesensitized().hashCode());
        result = prime * result + ((getGenderCHash() == null) ? 0 : getGenderCHash().hashCode());
        result = prime * result + ((getBirthdayCDesensitized() == null) ? 0 : getBirthdayCDesensitized().hashCode());
        result = prime * result + ((getBirthdayCHash() == null) ? 0 : getBirthdayCHash().hashCode());
        result = prime * result + ((getPhoneMobileCDesensitized() == null) ? 0 : getPhoneMobileCDesensitized().hashCode());
        result = prime * result + ((getPhoneMobileCHash() == null) ? 0 : getPhoneMobileCHash().hashCode());
        result = prime * result + ((getDateCreated() == null) ? 0 : getDateCreated().hashCode());
        result = prime * result + ((getDateModified() == null) ? 0 : getDateModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", crmId=").append(crmId);
        sb.append(", crmCode=").append(crmCode);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", pdsCode=").append(pdsCode);
        sb.append(", nameDesensitized=").append(nameDesensitized);
        sb.append(", nameHash=").append(nameHash);
        sb.append(", genderC=").append(genderC);
        sb.append(", genderCDesensitized=").append(genderCDesensitized);
        sb.append(", genderCHash=").append(genderCHash);
        sb.append(", birthdayCDesensitized=").append(birthdayCDesensitized);
        sb.append(", birthdayCHash=").append(birthdayCHash);
        sb.append(", phoneMobileCDesensitized=").append(phoneMobileCDesensitized);
        sb.append(", phoneMobileCHash=").append(phoneMobileCHash);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}