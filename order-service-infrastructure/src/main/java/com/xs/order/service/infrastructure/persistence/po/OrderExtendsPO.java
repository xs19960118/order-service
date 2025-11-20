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
 * 订单扩展表
 * @TableName order_extends
 */
@TableName(value ="order_extends")
@Data
public class OrderExtendsPO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 扩展表编号
     */
    private String extendCode;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 活动对象编码
     */
    private String itemCode;

    /**
     * 1. kidmax特殊标签
     */
    private Integer labelBit;

    /**
     * 产品编号
     */
    private String productCode;

    /**
     * 产品数量, 默认1
     */
    private Integer quantity;

    /**
     * 单位
     */
    private String unit;

    /**
     * 产品总价
     */
    private BigDecimal totalPrice;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 总税额
     */
    private BigDecimal taxAmount;

    /**
     * 版本号
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

    /**
     * 来源扩展编码
     */
    private String sourceExtendCode;

    /**
     * 顺序索引
     */
    private Integer index;

    /**
     * 合同报价税率
     */
    private BigDecimal contractTaxRate;

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
        OrderExtendsPO other = (OrderExtendsPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExtendCode() == null ? other.getExtendCode() == null : this.getExtendCode().equals(other.getExtendCode()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getItemCode() == null ? other.getItemCode() == null : this.getItemCode().equals(other.getItemCode()))
            && (this.getLabelBit() == null ? other.getLabelBit() == null : this.getLabelBit().equals(other.getLabelBit()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getTaxRate() == null ? other.getTaxRate() == null : this.getTaxRate().equals(other.getTaxRate()))
            && (this.getTaxAmount() == null ? other.getTaxAmount() == null : this.getTaxAmount().equals(other.getTaxAmount()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getSourceExtendCode() == null ? other.getSourceExtendCode() == null : this.getSourceExtendCode().equals(other.getSourceExtendCode()))
            && (this.getIndex() == null ? other.getIndex() == null : this.getIndex().equals(other.getIndex()))
            && (this.getContractTaxRate() == null ? other.getContractTaxRate() == null : this.getContractTaxRate().equals(other.getContractTaxRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExtendCode() == null) ? 0 : getExtendCode().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getItemCode() == null) ? 0 : getItemCode().hashCode());
        result = prime * result + ((getLabelBit() == null) ? 0 : getLabelBit().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getTaxRate() == null) ? 0 : getTaxRate().hashCode());
        result = prime * result + ((getTaxAmount() == null) ? 0 : getTaxAmount().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getSourceExtendCode() == null) ? 0 : getSourceExtendCode().hashCode());
        result = prime * result + ((getIndex() == null) ? 0 : getIndex().hashCode());
        result = prime * result + ((getContractTaxRate() == null) ? 0 : getContractTaxRate().hashCode());
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
        sb.append(", orderCode=").append(orderCode);
        sb.append(", itemCode=").append(itemCode);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", productCode=").append(productCode);
        sb.append(", quantity=").append(quantity);
        sb.append(", unit=").append(unit);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", taxAmount=").append(taxAmount);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", sourceExtendCode=").append(sourceExtendCode);
        sb.append(", index=").append(index);
        sb.append(", contractTaxRate=").append(contractTaxRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}