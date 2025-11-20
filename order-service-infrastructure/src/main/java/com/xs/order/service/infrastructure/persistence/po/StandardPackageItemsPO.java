package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 包裹明细表
 * @TableName standard_package_items
 */
@TableName(value ="standard_package_items")
@Data
public class StandardPackageItemsPO implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * standard_packages.code
     */
    private String packageCode;

    /**
     * standard_package_items.code
     */
    private String code;

    /**
     * 订单明细编号
     */
    private String extendCode;

    /**
     * 商品编号
     */
    private String productCode;

    /**
     * 商品总数量
     */
    private Long quantity;

    /**
     * 已发货数量
     */
    private Long countDispatch;

    /**
     * 已发货数量（CRM）
     */
    private Long countDispatchCrm;

    /**
     * 已收货数量
     */
    private Long countReceived;

    /**
     * 标签位
     */
    private Long labelBit;

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
        StandardPackageItemsPO other = (StandardPackageItemsPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPackageCode() == null ? other.getPackageCode() == null : this.getPackageCode().equals(other.getPackageCode()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getExtendCode() == null ? other.getExtendCode() == null : this.getExtendCode().equals(other.getExtendCode()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getCountDispatch() == null ? other.getCountDispatch() == null : this.getCountDispatch().equals(other.getCountDispatch()))
            && (this.getCountDispatchCrm() == null ? other.getCountDispatchCrm() == null : this.getCountDispatchCrm().equals(other.getCountDispatchCrm()))
            && (this.getCountReceived() == null ? other.getCountReceived() == null : this.getCountReceived().equals(other.getCountReceived()))
            && (this.getLabelBit() == null ? other.getLabelBit() == null : this.getLabelBit().equals(other.getLabelBit()))
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
        result = prime * result + ((getPackageCode() == null) ? 0 : getPackageCode().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getExtendCode() == null) ? 0 : getExtendCode().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getCountDispatch() == null) ? 0 : getCountDispatch().hashCode());
        result = prime * result + ((getCountDispatchCrm() == null) ? 0 : getCountDispatchCrm().hashCode());
        result = prime * result + ((getCountReceived() == null) ? 0 : getCountReceived().hashCode());
        result = prime * result + ((getLabelBit() == null) ? 0 : getLabelBit().hashCode());
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
        sb.append(", packageCode=").append(packageCode);
        sb.append(", code=").append(code);
        sb.append(", extendCode=").append(extendCode);
        sb.append(", productCode=").append(productCode);
        sb.append(", quantity=").append(quantity);
        sb.append(", countDispatch=").append(countDispatch);
        sb.append(", countDispatchCrm=").append(countDispatchCrm);
        sb.append(", countReceived=").append(countReceived);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}