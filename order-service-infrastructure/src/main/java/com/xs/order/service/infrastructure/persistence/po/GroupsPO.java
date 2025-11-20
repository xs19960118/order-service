package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 主数据-集团
 * @TableName groups
 */
@TableName(value ="groups")
@Data
public class GroupsPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 集团编号
     */
    private String code;

    /**
     * 集团名称
     */
    private String name;

    /**
     * 销售主体 1.北京，2.上海，3.沭阳，4.无锡
     */
    private Integer region;

    /**
     * 国家编号
     */
    private String country;

    /**
     * 省 编号
     */
    private String province;

    /**
     * 市 编号
     */
    private String city;

    /**
     * 区 编号
     */
    private String district;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 是否经销商，0.不是，1.是
     */
    private Integer isAgent;

    /**
     * 集团负责人
     */
    private Integer assignUid;

    /**
     * 事件投递时间
     */
    private Long timeAction;

    /**
     * 乐观锁
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
     * 区域编号
     */
    private String place;

    /**
     * 集团名全称
     */
    private String nameFull;

    /**
     * 邮编
     */
    private String postalCode;

    /**
     * 开票区域pds编码
     */
    private String invoicePdsCode;

    /**
     * 开票国家
     */
    private String invoiceCountry;

    /**
     * 开票省份
     */
    private String invoiceProvince;

    /**
     * 开票城市
     */
    private String invoiceCity;

    /**
     * 开票区县
     */
    private String invoiceDistrict;

    /**
     * 开票place
     */
    private String invoicePlace;

    /**
     * 开票详细地址
     */
    private String invoiceAddress;

    /**
     * 开票邮编
     */
    private String invoiceZipcode;

    /**
     * bill_name
     */
    private String invoiceNickname;

    /**
     * VAT 编号
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
        GroupsPO other = (GroupsPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getIsAgent() == null ? other.getIsAgent() == null : this.getIsAgent().equals(other.getIsAgent()))
            && (this.getAssignUid() == null ? other.getAssignUid() == null : this.getAssignUid().equals(other.getAssignUid()))
            && (this.getTimeAction() == null ? other.getTimeAction() == null : this.getTimeAction().equals(other.getTimeAction()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getNameFull() == null ? other.getNameFull() == null : this.getNameFull().equals(other.getNameFull()))
            && (this.getPostalCode() == null ? other.getPostalCode() == null : this.getPostalCode().equals(other.getPostalCode()))
            && (this.getInvoicePdsCode() == null ? other.getInvoicePdsCode() == null : this.getInvoicePdsCode().equals(other.getInvoicePdsCode()))
            && (this.getInvoiceCountry() == null ? other.getInvoiceCountry() == null : this.getInvoiceCountry().equals(other.getInvoiceCountry()))
            && (this.getInvoiceProvince() == null ? other.getInvoiceProvince() == null : this.getInvoiceProvince().equals(other.getInvoiceProvince()))
            && (this.getInvoiceCity() == null ? other.getInvoiceCity() == null : this.getInvoiceCity().equals(other.getInvoiceCity()))
            && (this.getInvoiceDistrict() == null ? other.getInvoiceDistrict() == null : this.getInvoiceDistrict().equals(other.getInvoiceDistrict()))
            && (this.getInvoicePlace() == null ? other.getInvoicePlace() == null : this.getInvoicePlace().equals(other.getInvoicePlace()))
            && (this.getInvoiceAddress() == null ? other.getInvoiceAddress() == null : this.getInvoiceAddress().equals(other.getInvoiceAddress()))
            && (this.getInvoiceZipcode() == null ? other.getInvoiceZipcode() == null : this.getInvoiceZipcode().equals(other.getInvoiceZipcode()))
            && (this.getInvoiceNickname() == null ? other.getInvoiceNickname() == null : this.getInvoiceNickname().equals(other.getInvoiceNickname()))
            && (this.getVatCode() == null ? other.getVatCode() == null : this.getVatCode().equals(other.getVatCode()))
            && (this.getViesVatCode() == null ? other.getViesVatCode() == null : this.getViesVatCode().equals(other.getViesVatCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getIsAgent() == null) ? 0 : getIsAgent().hashCode());
        result = prime * result + ((getAssignUid() == null) ? 0 : getAssignUid().hashCode());
        result = prime * result + ((getTimeAction() == null) ? 0 : getTimeAction().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getNameFull() == null) ? 0 : getNameFull().hashCode());
        result = prime * result + ((getPostalCode() == null) ? 0 : getPostalCode().hashCode());
        result = prime * result + ((getInvoicePdsCode() == null) ? 0 : getInvoicePdsCode().hashCode());
        result = prime * result + ((getInvoiceCountry() == null) ? 0 : getInvoiceCountry().hashCode());
        result = prime * result + ((getInvoiceProvince() == null) ? 0 : getInvoiceProvince().hashCode());
        result = prime * result + ((getInvoiceCity() == null) ? 0 : getInvoiceCity().hashCode());
        result = prime * result + ((getInvoiceDistrict() == null) ? 0 : getInvoiceDistrict().hashCode());
        result = prime * result + ((getInvoicePlace() == null) ? 0 : getInvoicePlace().hashCode());
        result = prime * result + ((getInvoiceAddress() == null) ? 0 : getInvoiceAddress().hashCode());
        result = prime * result + ((getInvoiceZipcode() == null) ? 0 : getInvoiceZipcode().hashCode());
        result = prime * result + ((getInvoiceNickname() == null) ? 0 : getInvoiceNickname().hashCode());
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
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", region=").append(region);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", address=").append(address);
        sb.append(", isAgent=").append(isAgent);
        sb.append(", assignUid=").append(assignUid);
        sb.append(", timeAction=").append(timeAction);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", place=").append(place);
        sb.append(", nameFull=").append(nameFull);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", invoicePdsCode=").append(invoicePdsCode);
        sb.append(", invoiceCountry=").append(invoiceCountry);
        sb.append(", invoiceProvince=").append(invoiceProvince);
        sb.append(", invoiceCity=").append(invoiceCity);
        sb.append(", invoiceDistrict=").append(invoiceDistrict);
        sb.append(", invoicePlace=").append(invoicePlace);
        sb.append(", invoiceAddress=").append(invoiceAddress);
        sb.append(", invoiceZipcode=").append(invoiceZipcode);
        sb.append(", invoiceNickname=").append(invoiceNickname);
        sb.append(", vatCode=").append(vatCode);
        sb.append(", viesVatCode=").append(viesVatCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}