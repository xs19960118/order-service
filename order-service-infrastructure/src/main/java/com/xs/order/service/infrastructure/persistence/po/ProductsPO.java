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
 * 主数据-产品表
 * @TableName products
 */
@TableName(value ="products")
@Data
public class ProductsPO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品类型：1.实物，10.非实物
     */
    private Integer type;

    /**
     * 商品名
     */
    private String name;

    /**
     * 
     */
    private String nameEn;

    /**
     * 商品编号
     */
    private String code;

    /**
     * 别名编号
     */
    private String aliasCode;

    /**
     * 商品等级
     */
    private Integer level;

    /**
     * 商品品牌
     */
    private String brand;

    /**
     * 订单类型限制:
1. 主订单
2. 附属订单
4. 外部订单
8. 口扫订单
16. 可以售卖的
32. 配件类
64. 海外产品
128. 白名单
256. 订单头商品
512. 活动管理-矫治器类型
1024. 活动管理-附属产品
     */
    private byte[] orderBit;

    /**
     * 是否可用 0.不可用， 1.可用
     */
    private Integer available;

    /**
     * 事件投递时间
     */
    private Long timeAction;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 税率, 0.13或者0.06
     */
    private BigDecimal taxRate;

    /**
     * 销售主体
     */
    private Integer region;

    /**
     * 商品税率类型 1.服务， 2.实物
     */
    private Integer taxType;

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
        ProductsPO other = (ProductsPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getAliasCode() == null ? other.getAliasCode() == null : this.getAliasCode().equals(other.getAliasCode()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (Arrays.equals(this.getOrderBit(), other.getOrderBit()))
            && (this.getAvailable() == null ? other.getAvailable() == null : this.getAvailable().equals(other.getAvailable()))
            && (this.getTimeAction() == null ? other.getTimeAction() == null : this.getTimeAction().equals(other.getTimeAction()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTaxRate() == null ? other.getTaxRate() == null : this.getTaxRate().equals(other.getTaxRate()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getTaxType() == null ? other.getTaxType() == null : this.getTaxType().equals(other.getTaxType()))
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
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getAliasCode() == null) ? 0 : getAliasCode().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + (Arrays.hashCode(getOrderBit()));
        result = prime * result + ((getAvailable() == null) ? 0 : getAvailable().hashCode());
        result = prime * result + ((getTimeAction() == null) ? 0 : getTimeAction().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTaxRate() == null) ? 0 : getTaxRate().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getTaxType() == null) ? 0 : getTaxType().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", nameEn=").append(nameEn);
        sb.append(", code=").append(code);
        sb.append(", aliasCode=").append(aliasCode);
        sb.append(", level=").append(level);
        sb.append(", brand=").append(brand);
        sb.append(", orderBit=").append(orderBit);
        sb.append(", available=").append(available);
        sb.append(", timeAction=").append(timeAction);
        sb.append(", price=").append(price);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", region=").append(region);
        sb.append(", taxType=").append(taxType);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}