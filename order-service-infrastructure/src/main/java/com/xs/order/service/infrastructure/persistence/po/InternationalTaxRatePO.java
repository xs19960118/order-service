package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName international_tax_rate
 */
@TableName(value ="international_tax_rate")
@Data
public class InternationalTaxRatePO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 国家编号(iso两位)
     */
    private String country;

    /**
     * 省(iso两位)
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postalCode;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * taxjar返回的明细
     */
    private String json;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 有效期时间戳
     */
    private Long timeLive;

    /**
     * 标识位， 1.不发钉钉提醒
     */
    private byte[] labelBit;

    /**
     * pds编号
     */
    private String pdsCode;

    /**
     * pds版本
     */
    private Long pdsVersion;

    /**
     * taxjar_city
     */
    private String taxjarCity;

    /**
     * taxjar_city_rate
     */
    private BigDecimal taxjarCityRate;

    /**
     * taxjar_combined_district_rate
     */
    private BigDecimal taxjarCombinedDistrictRate;

    /**
     * taxjar_combined_rate
     */
    private BigDecimal taxjarCombinedRate;

    /**
     * taxjar_country
     */
    private String taxjarCountry;

    /**
     * taxjar_country_rate
     */
    private BigDecimal taxjarCountryRate;

    /**
     * taxjar_county
     */
    private String taxjarCounty;

    /**
     * taxjar_county_rate
     */
    private BigDecimal taxjarCountyRate;

    /**
     * taxjar_state
     */
    private String taxjarState;

    /**
     * taxjar_state_rate
     */
    private BigDecimal taxjarStateRate;

    /**
     * taxjar_zip
     */
    private String taxjarZip;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间戳
     */
    private Long deleteTime;

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
        InternationalTaxRatePO other = (InternationalTaxRatePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPostalCode() == null ? other.getPostalCode() == null : this.getPostalCode().equals(other.getPostalCode()))
            && (this.getTaxRate() == null ? other.getTaxRate() == null : this.getTaxRate().equals(other.getTaxRate()))
            && (this.getJson() == null ? other.getJson() == null : this.getJson().equals(other.getJson()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTimeLive() == null ? other.getTimeLive() == null : this.getTimeLive().equals(other.getTimeLive()))
            && (Arrays.equals(this.getLabelBit(), other.getLabelBit()))
            && (this.getPdsCode() == null ? other.getPdsCode() == null : this.getPdsCode().equals(other.getPdsCode()))
            && (this.getPdsVersion() == null ? other.getPdsVersion() == null : this.getPdsVersion().equals(other.getPdsVersion()))
            && (this.getTaxjarCity() == null ? other.getTaxjarCity() == null : this.getTaxjarCity().equals(other.getTaxjarCity()))
            && (this.getTaxjarCityRate() == null ? other.getTaxjarCityRate() == null : this.getTaxjarCityRate().equals(other.getTaxjarCityRate()))
            && (this.getTaxjarCombinedDistrictRate() == null ? other.getTaxjarCombinedDistrictRate() == null : this.getTaxjarCombinedDistrictRate().equals(other.getTaxjarCombinedDistrictRate()))
            && (this.getTaxjarCombinedRate() == null ? other.getTaxjarCombinedRate() == null : this.getTaxjarCombinedRate().equals(other.getTaxjarCombinedRate()))
            && (this.getTaxjarCountry() == null ? other.getTaxjarCountry() == null : this.getTaxjarCountry().equals(other.getTaxjarCountry()))
            && (this.getTaxjarCountryRate() == null ? other.getTaxjarCountryRate() == null : this.getTaxjarCountryRate().equals(other.getTaxjarCountryRate()))
            && (this.getTaxjarCounty() == null ? other.getTaxjarCounty() == null : this.getTaxjarCounty().equals(other.getTaxjarCounty()))
            && (this.getTaxjarCountyRate() == null ? other.getTaxjarCountyRate() == null : this.getTaxjarCountyRate().equals(other.getTaxjarCountyRate()))
            && (this.getTaxjarState() == null ? other.getTaxjarState() == null : this.getTaxjarState().equals(other.getTaxjarState()))
            && (this.getTaxjarStateRate() == null ? other.getTaxjarStateRate() == null : this.getTaxjarStateRate().equals(other.getTaxjarStateRate()))
            && (this.getTaxjarZip() == null ? other.getTaxjarZip() == null : this.getTaxjarZip().equals(other.getTaxjarZip()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPostalCode() == null) ? 0 : getPostalCode().hashCode());
        result = prime * result + ((getTaxRate() == null) ? 0 : getTaxRate().hashCode());
        result = prime * result + ((getJson() == null) ? 0 : getJson().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTimeLive() == null) ? 0 : getTimeLive().hashCode());
        result = prime * result + (Arrays.hashCode(getLabelBit()));
        result = prime * result + ((getPdsCode() == null) ? 0 : getPdsCode().hashCode());
        result = prime * result + ((getPdsVersion() == null) ? 0 : getPdsVersion().hashCode());
        result = prime * result + ((getTaxjarCity() == null) ? 0 : getTaxjarCity().hashCode());
        result = prime * result + ((getTaxjarCityRate() == null) ? 0 : getTaxjarCityRate().hashCode());
        result = prime * result + ((getTaxjarCombinedDistrictRate() == null) ? 0 : getTaxjarCombinedDistrictRate().hashCode());
        result = prime * result + ((getTaxjarCombinedRate() == null) ? 0 : getTaxjarCombinedRate().hashCode());
        result = prime * result + ((getTaxjarCountry() == null) ? 0 : getTaxjarCountry().hashCode());
        result = prime * result + ((getTaxjarCountryRate() == null) ? 0 : getTaxjarCountryRate().hashCode());
        result = prime * result + ((getTaxjarCounty() == null) ? 0 : getTaxjarCounty().hashCode());
        result = prime * result + ((getTaxjarCountyRate() == null) ? 0 : getTaxjarCountyRate().hashCode());
        result = prime * result + ((getTaxjarState() == null) ? 0 : getTaxjarState().hashCode());
        result = prime * result + ((getTaxjarStateRate() == null) ? 0 : getTaxjarStateRate().hashCode());
        result = prime * result + ((getTaxjarZip() == null) ? 0 : getTaxjarZip().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", address=").append(address);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", json=").append(json);
        sb.append(", createTime=").append(createTime);
        sb.append(", timeLive=").append(timeLive);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", pdsCode=").append(pdsCode);
        sb.append(", pdsVersion=").append(pdsVersion);
        sb.append(", taxjarCity=").append(taxjarCity);
        sb.append(", taxjarCityRate=").append(taxjarCityRate);
        sb.append(", taxjarCombinedDistrictRate=").append(taxjarCombinedDistrictRate);
        sb.append(", taxjarCombinedRate=").append(taxjarCombinedRate);
        sb.append(", taxjarCountry=").append(taxjarCountry);
        sb.append(", taxjarCountryRate=").append(taxjarCountryRate);
        sb.append(", taxjarCounty=").append(taxjarCounty);
        sb.append(", taxjarCountyRate=").append(taxjarCountyRate);
        sb.append(", taxjarState=").append(taxjarState);
        sb.append(", taxjarStateRate=").append(taxjarStateRate);
        sb.append(", taxjarZip=").append(taxjarZip);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}