package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 医生迁移pds数据
 * @TableName doctor_pds_migrate_sit
 */
@TableName(value ="doctor_pds_migrate_sit")
@Data
public class DoctorPdsMigrateSitPO implements Serializable {
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 医生的CRM ID
     */
    private String crmId;

    /**
     * 医生在CRM的code
     */
    private String crmCode;

    /**
     * 医生国家二位编号
     */
    private String countryCode;

    /**
     * pds_code
     */
    private String pdsCode;

    /**
     * 姓名脱敏文
     */
    private String lastNameDesensitized;

    /**
     * 姓名hash
     */
    private String lastNameHash;

    /**
     * 名脱敏文
     */
    private String givenNameDesensitized;

    /**
     * 名hash
     */
    private String givenNameHash;

    /**
     * 姓脱敏文
     */
    private String surnameDesensitized;

    /**
     * 姓hash
     */
    private String surnameHash;

    /**
     * 联系方式号码脱敏文
     */
    private String contactNumberCDesensitized;

    /**
     * 联系方式号码hash
     */
    private String contactNumberCHash;

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
     * 移动电话一脱敏文
     */
    private String phoneMobileDesensitized;

    /**
     * 移动电话一hash
     */
    private String phoneMobileHash;

    /**
     * 固定电话脱敏文
     */
    private String phoneHomeDesensitized;

    /**
     * 固定电话hash
     */
    private String phoneHomeHash;

    /**
     * 称谓脱敏文
     */
    private String salutationDesensitized;

    /**
     * 称谓hash
     */
    private String salutationHash;

    /**
     * 出生日期脱敏文
     */
    private String birthdateDesensitized;

    /**
     * 出生日期hash
     */
    private String birthdateHash;

    /**
     * 微信号脱敏文
     */
    private String wechatCDesensitized;

    /**
     * 微信号hash
     */
    private String wechatCHash;

    /**
     * 移动电话二脱敏文
     */
    private String phoneWorkDesensitized;

    /**
     * 移动电话二hash
     */
    private String phoneWorkHash;

    /**
     * email地址脱敏文
     */
    private String emailCDesensitized;

    /**
     * email地址hash
     */
    private String emailCHash;

    /**
     * 有效证件号码脱敏文
     */
    private String certificateNumberCDesensitized;

    /**
     * 有效证件号码hash
     */
    private String certificateNumberCHash;

    /**
     * 银行账户信息-个人账号脱敏文
     */
    private String accountCDesensitized;

    /**
     * 银行账户信息-个人账号hash
     */
    private String accountCHash;

    /**
     * 银行账户信息-个人账号姓名脱敏文
     */
    private String accountNameCDesensitized;

    /**
     * 银行账户信息-个人账号姓名hash
     */
    private String accountNameCHash;

    /**
     * 银行账户信息-个人开户行脱敏文
     */
    private String accountBankCDesensitized;

    /**
     * 银行账户信息-个人开户行hash
     */
    private String accountBankCHash;

    /**
     * 婚姻状况脱敏文
     */
    private String marriageCDesensitized;

    /**
     * 婚姻状况hash
     */
    private String marriageCHash;

    /**
     * 个人信仰脱敏文
     */
    private String religiousCDesensitized;

    /**
     * 个人信仰hash
     */
    private String religiousCHash;

    /**
     * 邮编脱敏文
     */
    private String postalcodeCDesensitized;

    /**
     * 邮编hash
     */
    private String postalcodeCHash;

    /**
     * 详细地址脱敏文
     */
    private String addressCDesensitized;

    /**
     * 详细地址hash
     */
    private String addressCHash;

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
        DoctorPdsMigrateSitPO other = (DoctorPdsMigrateSitPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCrmId() == null ? other.getCrmId() == null : this.getCrmId().equals(other.getCrmId()))
            && (this.getCrmCode() == null ? other.getCrmCode() == null : this.getCrmCode().equals(other.getCrmCode()))
            && (this.getCountryCode() == null ? other.getCountryCode() == null : this.getCountryCode().equals(other.getCountryCode()))
            && (this.getPdsCode() == null ? other.getPdsCode() == null : this.getPdsCode().equals(other.getPdsCode()))
            && (this.getLastNameDesensitized() == null ? other.getLastNameDesensitized() == null : this.getLastNameDesensitized().equals(other.getLastNameDesensitized()))
            && (this.getLastNameHash() == null ? other.getLastNameHash() == null : this.getLastNameHash().equals(other.getLastNameHash()))
            && (this.getGivenNameDesensitized() == null ? other.getGivenNameDesensitized() == null : this.getGivenNameDesensitized().equals(other.getGivenNameDesensitized()))
            && (this.getGivenNameHash() == null ? other.getGivenNameHash() == null : this.getGivenNameHash().equals(other.getGivenNameHash()))
            && (this.getSurnameDesensitized() == null ? other.getSurnameDesensitized() == null : this.getSurnameDesensitized().equals(other.getSurnameDesensitized()))
            && (this.getSurnameHash() == null ? other.getSurnameHash() == null : this.getSurnameHash().equals(other.getSurnameHash()))
            && (this.getContactNumberCDesensitized() == null ? other.getContactNumberCDesensitized() == null : this.getContactNumberCDesensitized().equals(other.getContactNumberCDesensitized()))
            && (this.getContactNumberCHash() == null ? other.getContactNumberCHash() == null : this.getContactNumberCHash().equals(other.getContactNumberCHash()))
            && (this.getGenderC() == null ? other.getGenderC() == null : this.getGenderC().equals(other.getGenderC()))
            && (this.getGenderCDesensitized() == null ? other.getGenderCDesensitized() == null : this.getGenderCDesensitized().equals(other.getGenderCDesensitized()))
            && (this.getGenderCHash() == null ? other.getGenderCHash() == null : this.getGenderCHash().equals(other.getGenderCHash()))
            && (this.getPhoneMobileDesensitized() == null ? other.getPhoneMobileDesensitized() == null : this.getPhoneMobileDesensitized().equals(other.getPhoneMobileDesensitized()))
            && (this.getPhoneMobileHash() == null ? other.getPhoneMobileHash() == null : this.getPhoneMobileHash().equals(other.getPhoneMobileHash()))
            && (this.getPhoneHomeDesensitized() == null ? other.getPhoneHomeDesensitized() == null : this.getPhoneHomeDesensitized().equals(other.getPhoneHomeDesensitized()))
            && (this.getPhoneHomeHash() == null ? other.getPhoneHomeHash() == null : this.getPhoneHomeHash().equals(other.getPhoneHomeHash()))
            && (this.getSalutationDesensitized() == null ? other.getSalutationDesensitized() == null : this.getSalutationDesensitized().equals(other.getSalutationDesensitized()))
            && (this.getSalutationHash() == null ? other.getSalutationHash() == null : this.getSalutationHash().equals(other.getSalutationHash()))
            && (this.getBirthdateDesensitized() == null ? other.getBirthdateDesensitized() == null : this.getBirthdateDesensitized().equals(other.getBirthdateDesensitized()))
            && (this.getBirthdateHash() == null ? other.getBirthdateHash() == null : this.getBirthdateHash().equals(other.getBirthdateHash()))
            && (this.getWechatCDesensitized() == null ? other.getWechatCDesensitized() == null : this.getWechatCDesensitized().equals(other.getWechatCDesensitized()))
            && (this.getWechatCHash() == null ? other.getWechatCHash() == null : this.getWechatCHash().equals(other.getWechatCHash()))
            && (this.getPhoneWorkDesensitized() == null ? other.getPhoneWorkDesensitized() == null : this.getPhoneWorkDesensitized().equals(other.getPhoneWorkDesensitized()))
            && (this.getPhoneWorkHash() == null ? other.getPhoneWorkHash() == null : this.getPhoneWorkHash().equals(other.getPhoneWorkHash()))
            && (this.getEmailCDesensitized() == null ? other.getEmailCDesensitized() == null : this.getEmailCDesensitized().equals(other.getEmailCDesensitized()))
            && (this.getEmailCHash() == null ? other.getEmailCHash() == null : this.getEmailCHash().equals(other.getEmailCHash()))
            && (this.getCertificateNumberCDesensitized() == null ? other.getCertificateNumberCDesensitized() == null : this.getCertificateNumberCDesensitized().equals(other.getCertificateNumberCDesensitized()))
            && (this.getCertificateNumberCHash() == null ? other.getCertificateNumberCHash() == null : this.getCertificateNumberCHash().equals(other.getCertificateNumberCHash()))
            && (this.getAccountCDesensitized() == null ? other.getAccountCDesensitized() == null : this.getAccountCDesensitized().equals(other.getAccountCDesensitized()))
            && (this.getAccountCHash() == null ? other.getAccountCHash() == null : this.getAccountCHash().equals(other.getAccountCHash()))
            && (this.getAccountNameCDesensitized() == null ? other.getAccountNameCDesensitized() == null : this.getAccountNameCDesensitized().equals(other.getAccountNameCDesensitized()))
            && (this.getAccountNameCHash() == null ? other.getAccountNameCHash() == null : this.getAccountNameCHash().equals(other.getAccountNameCHash()))
            && (this.getAccountBankCDesensitized() == null ? other.getAccountBankCDesensitized() == null : this.getAccountBankCDesensitized().equals(other.getAccountBankCDesensitized()))
            && (this.getAccountBankCHash() == null ? other.getAccountBankCHash() == null : this.getAccountBankCHash().equals(other.getAccountBankCHash()))
            && (this.getMarriageCDesensitized() == null ? other.getMarriageCDesensitized() == null : this.getMarriageCDesensitized().equals(other.getMarriageCDesensitized()))
            && (this.getMarriageCHash() == null ? other.getMarriageCHash() == null : this.getMarriageCHash().equals(other.getMarriageCHash()))
            && (this.getReligiousCDesensitized() == null ? other.getReligiousCDesensitized() == null : this.getReligiousCDesensitized().equals(other.getReligiousCDesensitized()))
            && (this.getReligiousCHash() == null ? other.getReligiousCHash() == null : this.getReligiousCHash().equals(other.getReligiousCHash()))
            && (this.getPostalcodeCDesensitized() == null ? other.getPostalcodeCDesensitized() == null : this.getPostalcodeCDesensitized().equals(other.getPostalcodeCDesensitized()))
            && (this.getPostalcodeCHash() == null ? other.getPostalcodeCHash() == null : this.getPostalcodeCHash().equals(other.getPostalcodeCHash()))
            && (this.getAddressCDesensitized() == null ? other.getAddressCDesensitized() == null : this.getAddressCDesensitized().equals(other.getAddressCDesensitized()))
            && (this.getAddressCHash() == null ? other.getAddressCHash() == null : this.getAddressCHash().equals(other.getAddressCHash()))
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
        result = prime * result + ((getLastNameDesensitized() == null) ? 0 : getLastNameDesensitized().hashCode());
        result = prime * result + ((getLastNameHash() == null) ? 0 : getLastNameHash().hashCode());
        result = prime * result + ((getGivenNameDesensitized() == null) ? 0 : getGivenNameDesensitized().hashCode());
        result = prime * result + ((getGivenNameHash() == null) ? 0 : getGivenNameHash().hashCode());
        result = prime * result + ((getSurnameDesensitized() == null) ? 0 : getSurnameDesensitized().hashCode());
        result = prime * result + ((getSurnameHash() == null) ? 0 : getSurnameHash().hashCode());
        result = prime * result + ((getContactNumberCDesensitized() == null) ? 0 : getContactNumberCDesensitized().hashCode());
        result = prime * result + ((getContactNumberCHash() == null) ? 0 : getContactNumberCHash().hashCode());
        result = prime * result + ((getGenderC() == null) ? 0 : getGenderC().hashCode());
        result = prime * result + ((getGenderCDesensitized() == null) ? 0 : getGenderCDesensitized().hashCode());
        result = prime * result + ((getGenderCHash() == null) ? 0 : getGenderCHash().hashCode());
        result = prime * result + ((getPhoneMobileDesensitized() == null) ? 0 : getPhoneMobileDesensitized().hashCode());
        result = prime * result + ((getPhoneMobileHash() == null) ? 0 : getPhoneMobileHash().hashCode());
        result = prime * result + ((getPhoneHomeDesensitized() == null) ? 0 : getPhoneHomeDesensitized().hashCode());
        result = prime * result + ((getPhoneHomeHash() == null) ? 0 : getPhoneHomeHash().hashCode());
        result = prime * result + ((getSalutationDesensitized() == null) ? 0 : getSalutationDesensitized().hashCode());
        result = prime * result + ((getSalutationHash() == null) ? 0 : getSalutationHash().hashCode());
        result = prime * result + ((getBirthdateDesensitized() == null) ? 0 : getBirthdateDesensitized().hashCode());
        result = prime * result + ((getBirthdateHash() == null) ? 0 : getBirthdateHash().hashCode());
        result = prime * result + ((getWechatCDesensitized() == null) ? 0 : getWechatCDesensitized().hashCode());
        result = prime * result + ((getWechatCHash() == null) ? 0 : getWechatCHash().hashCode());
        result = prime * result + ((getPhoneWorkDesensitized() == null) ? 0 : getPhoneWorkDesensitized().hashCode());
        result = prime * result + ((getPhoneWorkHash() == null) ? 0 : getPhoneWorkHash().hashCode());
        result = prime * result + ((getEmailCDesensitized() == null) ? 0 : getEmailCDesensitized().hashCode());
        result = prime * result + ((getEmailCHash() == null) ? 0 : getEmailCHash().hashCode());
        result = prime * result + ((getCertificateNumberCDesensitized() == null) ? 0 : getCertificateNumberCDesensitized().hashCode());
        result = prime * result + ((getCertificateNumberCHash() == null) ? 0 : getCertificateNumberCHash().hashCode());
        result = prime * result + ((getAccountCDesensitized() == null) ? 0 : getAccountCDesensitized().hashCode());
        result = prime * result + ((getAccountCHash() == null) ? 0 : getAccountCHash().hashCode());
        result = prime * result + ((getAccountNameCDesensitized() == null) ? 0 : getAccountNameCDesensitized().hashCode());
        result = prime * result + ((getAccountNameCHash() == null) ? 0 : getAccountNameCHash().hashCode());
        result = prime * result + ((getAccountBankCDesensitized() == null) ? 0 : getAccountBankCDesensitized().hashCode());
        result = prime * result + ((getAccountBankCHash() == null) ? 0 : getAccountBankCHash().hashCode());
        result = prime * result + ((getMarriageCDesensitized() == null) ? 0 : getMarriageCDesensitized().hashCode());
        result = prime * result + ((getMarriageCHash() == null) ? 0 : getMarriageCHash().hashCode());
        result = prime * result + ((getReligiousCDesensitized() == null) ? 0 : getReligiousCDesensitized().hashCode());
        result = prime * result + ((getReligiousCHash() == null) ? 0 : getReligiousCHash().hashCode());
        result = prime * result + ((getPostalcodeCDesensitized() == null) ? 0 : getPostalcodeCDesensitized().hashCode());
        result = prime * result + ((getPostalcodeCHash() == null) ? 0 : getPostalcodeCHash().hashCode());
        result = prime * result + ((getAddressCDesensitized() == null) ? 0 : getAddressCDesensitized().hashCode());
        result = prime * result + ((getAddressCHash() == null) ? 0 : getAddressCHash().hashCode());
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
        sb.append(", lastNameDesensitized=").append(lastNameDesensitized);
        sb.append(", lastNameHash=").append(lastNameHash);
        sb.append(", givenNameDesensitized=").append(givenNameDesensitized);
        sb.append(", givenNameHash=").append(givenNameHash);
        sb.append(", surnameDesensitized=").append(surnameDesensitized);
        sb.append(", surnameHash=").append(surnameHash);
        sb.append(", contactNumberCDesensitized=").append(contactNumberCDesensitized);
        sb.append(", contactNumberCHash=").append(contactNumberCHash);
        sb.append(", genderC=").append(genderC);
        sb.append(", genderCDesensitized=").append(genderCDesensitized);
        sb.append(", genderCHash=").append(genderCHash);
        sb.append(", phoneMobileDesensitized=").append(phoneMobileDesensitized);
        sb.append(", phoneMobileHash=").append(phoneMobileHash);
        sb.append(", phoneHomeDesensitized=").append(phoneHomeDesensitized);
        sb.append(", phoneHomeHash=").append(phoneHomeHash);
        sb.append(", salutationDesensitized=").append(salutationDesensitized);
        sb.append(", salutationHash=").append(salutationHash);
        sb.append(", birthdateDesensitized=").append(birthdateDesensitized);
        sb.append(", birthdateHash=").append(birthdateHash);
        sb.append(", wechatCDesensitized=").append(wechatCDesensitized);
        sb.append(", wechatCHash=").append(wechatCHash);
        sb.append(", phoneWorkDesensitized=").append(phoneWorkDesensitized);
        sb.append(", phoneWorkHash=").append(phoneWorkHash);
        sb.append(", emailCDesensitized=").append(emailCDesensitized);
        sb.append(", emailCHash=").append(emailCHash);
        sb.append(", certificateNumberCDesensitized=").append(certificateNumberCDesensitized);
        sb.append(", certificateNumberCHash=").append(certificateNumberCHash);
        sb.append(", accountCDesensitized=").append(accountCDesensitized);
        sb.append(", accountCHash=").append(accountCHash);
        sb.append(", accountNameCDesensitized=").append(accountNameCDesensitized);
        sb.append(", accountNameCHash=").append(accountNameCHash);
        sb.append(", accountBankCDesensitized=").append(accountBankCDesensitized);
        sb.append(", accountBankCHash=").append(accountBankCHash);
        sb.append(", marriageCDesensitized=").append(marriageCDesensitized);
        sb.append(", marriageCHash=").append(marriageCHash);
        sb.append(", religiousCDesensitized=").append(religiousCDesensitized);
        sb.append(", religiousCHash=").append(religiousCHash);
        sb.append(", postalcodeCDesensitized=").append(postalcodeCDesensitized);
        sb.append(", postalcodeCHash=").append(postalcodeCHash);
        sb.append(", addressCDesensitized=").append(addressCDesensitized);
        sb.append(", addressCHash=").append(addressCHash);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}