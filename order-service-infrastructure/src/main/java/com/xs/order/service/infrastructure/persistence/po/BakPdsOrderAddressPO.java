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
 * @TableName bak_pds_order_address
 */
@TableName(value ="bak_pds_order_address")
@Data
public class BakPdsOrderAddressPO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 联系人pds编码
     */
    private String pdsCodeContact;

    /**
     * 地址pds编码
     */
    private String pdsCodeAddress;

    /**
     * 联系人pds版本
     */
    private Integer pdsVersionContact;

    /**
     * 地址pds版本
     */
    private Integer pdsVersionAddress;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 国家编号
     */
    private String country;

    /**
     * 省编号
     */
    private String province;

    /**
     * 市编号
     */
    private String city;

    /**
     * 区编号
     */
    private String district;

    /**
     * 收件人姓名
     */
    private String name;

    /**
     * 手机编号
     */
    private String mobile;

    /**
     * 邮编
     */
    private String postalCode;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
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
        BakPdsOrderAddressPO other = (BakPdsOrderAddressPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPdsCodeContact() == null ? other.getPdsCodeContact() == null : this.getPdsCodeContact().equals(other.getPdsCodeContact()))
            && (this.getPdsCodeAddress() == null ? other.getPdsCodeAddress() == null : this.getPdsCodeAddress().equals(other.getPdsCodeAddress()))
            && (this.getPdsVersionContact() == null ? other.getPdsVersionContact() == null : this.getPdsVersionContact().equals(other.getPdsVersionContact()))
            && (this.getPdsVersionAddress() == null ? other.getPdsVersionAddress() == null : this.getPdsVersionAddress().equals(other.getPdsVersionAddress()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getPostalCode() == null ? other.getPostalCode() == null : this.getPostalCode().equals(other.getPostalCode()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPdsCodeContact() == null) ? 0 : getPdsCodeContact().hashCode());
        result = prime * result + ((getPdsCodeAddress() == null) ? 0 : getPdsCodeAddress().hashCode());
        result = prime * result + ((getPdsVersionContact() == null) ? 0 : getPdsVersionContact().hashCode());
        result = prime * result + ((getPdsVersionAddress() == null) ? 0 : getPdsVersionAddress().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getPostalCode() == null) ? 0 : getPostalCode().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pdsCodeContact=").append(pdsCodeContact);
        sb.append(", pdsCodeAddress=").append(pdsCodeAddress);
        sb.append(", pdsVersionContact=").append(pdsVersionContact);
        sb.append(", pdsVersionAddress=").append(pdsVersionAddress);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", name=").append(name);
        sb.append(", mobile=").append(mobile);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", address=").append(address);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", place=").append(place);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}