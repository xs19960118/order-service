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
 * 海外订单扩展表
 * @TableName order_international_attribute
 */
@TableName(value ="order_international_attribute")
@Data
public class OrderInternationalAttributePO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * list price价格
     */
    private BigDecimal listPrice;

    /**
     * contract price价格
     */
    private BigDecimal contractPrice;

    /**
     * shipping_to的pds_code
     */
    private String shipToPdsCode;

    /**
     * shipping_to的pds_version
     */
    private Integer shipToPdsVersion;

    /**
     * 订单首次发货时间
     */
    private Long timeFirstProduction;

    /**
     * 特殊标签 1.合同含税，2.VAT_REDUCED
     */
    private byte[] labelBit;

    /**
     * international_tax_rate.id
     */
    private Long rateId;

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
     * 地址编号
     */
    private String addressCode;

    /**
     * 额外费用json
     */
    private String extraFeeJson;

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
        OrderInternationalAttributePO other = (OrderInternationalAttributePO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getListPrice() == null ? other.getListPrice() == null : this.getListPrice().equals(other.getListPrice()))
            && (this.getContractPrice() == null ? other.getContractPrice() == null : this.getContractPrice().equals(other.getContractPrice()))
            && (this.getShipToPdsCode() == null ? other.getShipToPdsCode() == null : this.getShipToPdsCode().equals(other.getShipToPdsCode()))
            && (this.getShipToPdsVersion() == null ? other.getShipToPdsVersion() == null : this.getShipToPdsVersion().equals(other.getShipToPdsVersion()))
            && (this.getTimeFirstProduction() == null ? other.getTimeFirstProduction() == null : this.getTimeFirstProduction().equals(other.getTimeFirstProduction()))
            && (Arrays.equals(this.getLabelBit(), other.getLabelBit()))
            && (this.getRateId() == null ? other.getRateId() == null : this.getRateId().equals(other.getRateId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getAddressCode() == null ? other.getAddressCode() == null : this.getAddressCode().equals(other.getAddressCode()))
            && (this.getExtraFeeJson() == null ? other.getExtraFeeJson() == null : this.getExtraFeeJson().equals(other.getExtraFeeJson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getListPrice() == null) ? 0 : getListPrice().hashCode());
        result = prime * result + ((getContractPrice() == null) ? 0 : getContractPrice().hashCode());
        result = prime * result + ((getShipToPdsCode() == null) ? 0 : getShipToPdsCode().hashCode());
        result = prime * result + ((getShipToPdsVersion() == null) ? 0 : getShipToPdsVersion().hashCode());
        result = prime * result + ((getTimeFirstProduction() == null) ? 0 : getTimeFirstProduction().hashCode());
        result = prime * result + (Arrays.hashCode(getLabelBit()));
        result = prime * result + ((getRateId() == null) ? 0 : getRateId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getAddressCode() == null) ? 0 : getAddressCode().hashCode());
        result = prime * result + ((getExtraFeeJson() == null) ? 0 : getExtraFeeJson().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", listPrice=").append(listPrice);
        sb.append(", contractPrice=").append(contractPrice);
        sb.append(", shipToPdsCode=").append(shipToPdsCode);
        sb.append(", shipToPdsVersion=").append(shipToPdsVersion);
        sb.append(", timeFirstProduction=").append(timeFirstProduction);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", rateId=").append(rateId);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", addressCode=").append(addressCode);
        sb.append(", extraFeeJson=").append(extraFeeJson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}