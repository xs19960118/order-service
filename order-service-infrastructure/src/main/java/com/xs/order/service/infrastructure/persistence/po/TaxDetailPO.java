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
 * 
 * @TableName tax_detail
 */
@TableName(value ="tax_detail")
@Data
public class TaxDetailPO implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * order_extend.extend_code
     */
    private String extendCode;

    /**
     * 1.AUTO, 2.FIXED, 3.HYBRID, 4.MANUAL
     */
    private Integer type;

    /**
     * orders.order_code
     */
    private String orderCode;

    /**
     * 国家税率
     */
    private BigDecimal countryRate;

    /**
     * 州税率
     */
    private BigDecimal stateRate;

    /**
     * 县税率
     */
    private BigDecimal countyRate;

    /**
     * 城市税率
     */
    private BigDecimal cityRate;

    /**
     * 地区税率
     */
    private BigDecimal districtRate;

    /**
     * 手动调整的税率
     */
    private BigDecimal manualRate;

    /**
     * 组合税率
     */
    private BigDecimal combinedRate;

    /**
     * 邮编
     */
    private String postalCode;

    /**
     * 版本控制锁
     */
    private Integer version;

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
        TaxDetailPO other = (TaxDetailPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExtendCode() == null ? other.getExtendCode() == null : this.getExtendCode().equals(other.getExtendCode()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getCountryRate() == null ? other.getCountryRate() == null : this.getCountryRate().equals(other.getCountryRate()))
            && (this.getStateRate() == null ? other.getStateRate() == null : this.getStateRate().equals(other.getStateRate()))
            && (this.getCountyRate() == null ? other.getCountyRate() == null : this.getCountyRate().equals(other.getCountyRate()))
            && (this.getCityRate() == null ? other.getCityRate() == null : this.getCityRate().equals(other.getCityRate()))
            && (this.getDistrictRate() == null ? other.getDistrictRate() == null : this.getDistrictRate().equals(other.getDistrictRate()))
            && (this.getManualRate() == null ? other.getManualRate() == null : this.getManualRate().equals(other.getManualRate()))
            && (this.getCombinedRate() == null ? other.getCombinedRate() == null : this.getCombinedRate().equals(other.getCombinedRate()))
            && (this.getPostalCode() == null ? other.getPostalCode() == null : this.getPostalCode().equals(other.getPostalCode()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExtendCode() == null) ? 0 : getExtendCode().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getCountryRate() == null) ? 0 : getCountryRate().hashCode());
        result = prime * result + ((getStateRate() == null) ? 0 : getStateRate().hashCode());
        result = prime * result + ((getCountyRate() == null) ? 0 : getCountyRate().hashCode());
        result = prime * result + ((getCityRate() == null) ? 0 : getCityRate().hashCode());
        result = prime * result + ((getDistrictRate() == null) ? 0 : getDistrictRate().hashCode());
        result = prime * result + ((getManualRate() == null) ? 0 : getManualRate().hashCode());
        result = prime * result + ((getCombinedRate() == null) ? 0 : getCombinedRate().hashCode());
        result = prime * result + ((getPostalCode() == null) ? 0 : getPostalCode().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", extendCode=").append(extendCode);
        sb.append(", type=").append(type);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", countryRate=").append(countryRate);
        sb.append(", stateRate=").append(stateRate);
        sb.append(", countyRate=").append(countyRate);
        sb.append(", cityRate=").append(cityRate);
        sb.append(", districtRate=").append(districtRate);
        sb.append(", manualRate=").append(manualRate);
        sb.append(", combinedRate=").append(combinedRate);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}