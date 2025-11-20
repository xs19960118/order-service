package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName ba
 */
@TableName(value ="ba")
@Data
public class BaPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * ba账户名称
     */
    private String name;

    /**
     * ba账号
     */
    private String code;

    /**
     * ba类型，1.企业， 2.个人
     */
    private Integer type;

    /**
     * 销售主体 1.北京，2.上海，3.沭阳，4.无锡
     */
    private Integer region;

    /**
     * 代理编号
     */
    private String agentCode;

    /**
     * 机构编号
     */
    private String accountCode;

    /**
     * 医生编码
     */
    private String doctorCode;

    /**
     * 负责人id
     */
    private Integer assignUid;

    /**
     * 标签位
     */
    private Long labelBit;

    /**
     * invoice_pds_code
     */
    private String invoicePdsCode;

    /**
     * 操作时间戳
     */
    private Long timeAction;

    /**
     * 版本控制锁
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
     * 删除时间戳
     */
    private Long deleteTime;

    /**
     * 开票区域-收件人姓名
     */
    private String invoiceNickname;

    /**
     * 开票区域-国家
     */
    private String invoiceCountry;

    /**
     * 开票区域-省
     */
    private String invoiceProvince;

    /**
     * 开票区域-城市
     */
    private String invoiceCity;

    /**
     * 开票区域-区
     */
    private String invoiceDistrict;

    /**
     * 开票区域-place
     */
    private String invoicePlace;

    /**
     * 开票区域-zipcode
     */
    private String invoiceZipcode;

    /**
     * 开票区域-详细地址
     */
    private String invoiceAddress;

    /**
     * VAT编号
     */
    private String vatCode;

    /**
     * vies vat 编号
     */
    private String viesVatCode;

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
        BaPO other = (BaPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getAgentCode() == null ? other.getAgentCode() == null : this.getAgentCode().equals(other.getAgentCode()))
            && (this.getAccountCode() == null ? other.getAccountCode() == null : this.getAccountCode().equals(other.getAccountCode()))
            && (this.getDoctorCode() == null ? other.getDoctorCode() == null : this.getDoctorCode().equals(other.getDoctorCode()))
            && (this.getAssignUid() == null ? other.getAssignUid() == null : this.getAssignUid().equals(other.getAssignUid()))
            && (this.getLabelBit() == null ? other.getLabelBit() == null : this.getLabelBit().equals(other.getLabelBit()))
            && (this.getInvoicePdsCode() == null ? other.getInvoicePdsCode() == null : this.getInvoicePdsCode().equals(other.getInvoicePdsCode()))
            && (this.getTimeAction() == null ? other.getTimeAction() == null : this.getTimeAction().equals(other.getTimeAction()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getInvoiceNickname() == null ? other.getInvoiceNickname() == null : this.getInvoiceNickname().equals(other.getInvoiceNickname()))
            && (this.getInvoiceCountry() == null ? other.getInvoiceCountry() == null : this.getInvoiceCountry().equals(other.getInvoiceCountry()))
            && (this.getInvoiceProvince() == null ? other.getInvoiceProvince() == null : this.getInvoiceProvince().equals(other.getInvoiceProvince()))
            && (this.getInvoiceCity() == null ? other.getInvoiceCity() == null : this.getInvoiceCity().equals(other.getInvoiceCity()))
            && (this.getInvoiceDistrict() == null ? other.getInvoiceDistrict() == null : this.getInvoiceDistrict().equals(other.getInvoiceDistrict()))
            && (this.getInvoicePlace() == null ? other.getInvoicePlace() == null : this.getInvoicePlace().equals(other.getInvoicePlace()))
            && (this.getInvoiceZipcode() == null ? other.getInvoiceZipcode() == null : this.getInvoiceZipcode().equals(other.getInvoiceZipcode()))
            && (this.getInvoiceAddress() == null ? other.getInvoiceAddress() == null : this.getInvoiceAddress().equals(other.getInvoiceAddress()))
            && (this.getVatCode() == null ? other.getVatCode() == null : this.getVatCode().equals(other.getVatCode()))
            && (this.getViesVatCode() == null ? other.getViesVatCode() == null : this.getViesVatCode().equals(other.getViesVatCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getAgentCode() == null) ? 0 : getAgentCode().hashCode());
        result = prime * result + ((getAccountCode() == null) ? 0 : getAccountCode().hashCode());
        result = prime * result + ((getDoctorCode() == null) ? 0 : getDoctorCode().hashCode());
        result = prime * result + ((getAssignUid() == null) ? 0 : getAssignUid().hashCode());
        result = prime * result + ((getLabelBit() == null) ? 0 : getLabelBit().hashCode());
        result = prime * result + ((getInvoicePdsCode() == null) ? 0 : getInvoicePdsCode().hashCode());
        result = prime * result + ((getTimeAction() == null) ? 0 : getTimeAction().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getInvoiceNickname() == null) ? 0 : getInvoiceNickname().hashCode());
        result = prime * result + ((getInvoiceCountry() == null) ? 0 : getInvoiceCountry().hashCode());
        result = prime * result + ((getInvoiceProvince() == null) ? 0 : getInvoiceProvince().hashCode());
        result = prime * result + ((getInvoiceCity() == null) ? 0 : getInvoiceCity().hashCode());
        result = prime * result + ((getInvoiceDistrict() == null) ? 0 : getInvoiceDistrict().hashCode());
        result = prime * result + ((getInvoicePlace() == null) ? 0 : getInvoicePlace().hashCode());
        result = prime * result + ((getInvoiceZipcode() == null) ? 0 : getInvoiceZipcode().hashCode());
        result = prime * result + ((getInvoiceAddress() == null) ? 0 : getInvoiceAddress().hashCode());
        result = prime * result + ((getVatCode() == null) ? 0 : getVatCode().hashCode());
        result = prime * result + ((getViesVatCode() == null) ? 0 : getViesVatCode().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", region=").append(region);
        sb.append(", agentCode=").append(agentCode);
        sb.append(", accountCode=").append(accountCode);
        sb.append(", doctorCode=").append(doctorCode);
        sb.append(", assignUid=").append(assignUid);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", invoicePdsCode=").append(invoicePdsCode);
        sb.append(", timeAction=").append(timeAction);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", invoiceNickname=").append(invoiceNickname);
        sb.append(", invoiceCountry=").append(invoiceCountry);
        sb.append(", invoiceProvince=").append(invoiceProvince);
        sb.append(", invoiceCity=").append(invoiceCity);
        sb.append(", invoiceDistrict=").append(invoiceDistrict);
        sb.append(", invoicePlace=").append(invoicePlace);
        sb.append(", invoiceZipcode=").append(invoiceZipcode);
        sb.append(", invoiceAddress=").append(invoiceAddress);
        sb.append(", vatCode=").append(vatCode);
        sb.append(", viesVatCode=").append(viesVatCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}