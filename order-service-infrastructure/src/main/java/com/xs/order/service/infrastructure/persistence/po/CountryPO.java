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
 * @TableName country
 */
@TableName(value ="country")
@Data
public class CountryPO implements Serializable {
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 国家编码
     */
    private String code;

    /**
     * 货币
     */
    private String currency;

    /**
     * 
     */
    private Integer isCountry;

    /**
     * 是否禁用 0:否 1:是
     */
    private Integer disabled;

    /**
     * 显示时排序
     */
    private Integer sort;

    /**
     * 简体中文
     */
    private String zhCn;

    /**
     * 英文
     */
    private String enUs;

    /**
     * 二字简写
     */
    private String alpha2;

    /**
     * 三字简写
     */
    private String alpha3;

    /**
     * 标签位
     */
    private Integer labelBit;

    /**
     * 
     */
    private String region;

    /**
     * 最后一次修改人uid
     */
    private Integer modifyUid;

    /**
     * 修改时间
     */
    private Date updateTime;

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
        CountryPO other = (CountryPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getIsCountry() == null ? other.getIsCountry() == null : this.getIsCountry().equals(other.getIsCountry()))
            && (this.getDisabled() == null ? other.getDisabled() == null : this.getDisabled().equals(other.getDisabled()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getZhCn() == null ? other.getZhCn() == null : this.getZhCn().equals(other.getZhCn()))
            && (this.getEnUs() == null ? other.getEnUs() == null : this.getEnUs().equals(other.getEnUs()))
            && (this.getAlpha2() == null ? other.getAlpha2() == null : this.getAlpha2().equals(other.getAlpha2()))
            && (this.getAlpha3() == null ? other.getAlpha3() == null : this.getAlpha3().equals(other.getAlpha3()))
            && (this.getLabelBit() == null ? other.getLabelBit() == null : this.getLabelBit().equals(other.getLabelBit()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getModifyUid() == null ? other.getModifyUid() == null : this.getModifyUid().equals(other.getModifyUid()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getIsCountry() == null) ? 0 : getIsCountry().hashCode());
        result = prime * result + ((getDisabled() == null) ? 0 : getDisabled().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getZhCn() == null) ? 0 : getZhCn().hashCode());
        result = prime * result + ((getEnUs() == null) ? 0 : getEnUs().hashCode());
        result = prime * result + ((getAlpha2() == null) ? 0 : getAlpha2().hashCode());
        result = prime * result + ((getAlpha3() == null) ? 0 : getAlpha3().hashCode());
        result = prime * result + ((getLabelBit() == null) ? 0 : getLabelBit().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getModifyUid() == null) ? 0 : getModifyUid().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
        sb.append(", currency=").append(currency);
        sb.append(", isCountry=").append(isCountry);
        sb.append(", disabled=").append(disabled);
        sb.append(", sort=").append(sort);
        sb.append(", zhCn=").append(zhCn);
        sb.append(", enUs=").append(enUs);
        sb.append(", alpha2=").append(alpha2);
        sb.append(", alpha3=").append(alpha3);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", region=").append(region);
        sb.append(", modifyUid=").append(modifyUid);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}