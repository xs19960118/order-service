package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ssa活动表
 * @TableName ssa_promotion
 */
@TableName(value ="ssa_promotion")
@Data
public class SsaPromotionPO implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动编码
     */
    private String code;

    /**
     * 活动类型. 101.定金抵扣
     */
    private Integer type;

    /**
     * 状态. 0.待生效 1.已生效，10.失效, 11.已过期
     */
    private Integer status;

    /**
     * 活动开始时间
     */
    private Date promotionDatetimeStart;

    /**
     * 活动结束时间
     */
    private Date promotionDatetimeEnd;

    /**
     * 时区
     */
    private String timezone;

    /**
     * 数量
     */
    private Integer amountTotal;

    /**
     * 区域
     */
    private String areas;

    /**
     * 货币类型
     */
    private String currencies;

    /**
     * 备注
     */
    private String note;

    /**
     * 创建人
     */
    private Integer createUid;

    /**
     * 修改人
     */
    private Integer modifyUid;

    /**
     * bit标签， 1.存在活动对象
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
        SsaPromotionPO other = (SsaPromotionPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPromotionDatetimeStart() == null ? other.getPromotionDatetimeStart() == null : this.getPromotionDatetimeStart().equals(other.getPromotionDatetimeStart()))
            && (this.getPromotionDatetimeEnd() == null ? other.getPromotionDatetimeEnd() == null : this.getPromotionDatetimeEnd().equals(other.getPromotionDatetimeEnd()))
            && (this.getTimezone() == null ? other.getTimezone() == null : this.getTimezone().equals(other.getTimezone()))
            && (this.getAmountTotal() == null ? other.getAmountTotal() == null : this.getAmountTotal().equals(other.getAmountTotal()))
            && (this.getAreas() == null ? other.getAreas() == null : this.getAreas().equals(other.getAreas()))
            && (this.getCurrencies() == null ? other.getCurrencies() == null : this.getCurrencies().equals(other.getCurrencies()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid().equals(other.getCreateUid()))
            && (this.getModifyUid() == null ? other.getModifyUid() == null : this.getModifyUid().equals(other.getModifyUid()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPromotionDatetimeStart() == null) ? 0 : getPromotionDatetimeStart().hashCode());
        result = prime * result + ((getPromotionDatetimeEnd() == null) ? 0 : getPromotionDatetimeEnd().hashCode());
        result = prime * result + ((getTimezone() == null) ? 0 : getTimezone().hashCode());
        result = prime * result + ((getAmountTotal() == null) ? 0 : getAmountTotal().hashCode());
        result = prime * result + ((getAreas() == null) ? 0 : getAreas().hashCode());
        result = prime * result + ((getCurrencies() == null) ? 0 : getCurrencies().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
        result = prime * result + ((getModifyUid() == null) ? 0 : getModifyUid().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", promotionDatetimeStart=").append(promotionDatetimeStart);
        sb.append(", promotionDatetimeEnd=").append(promotionDatetimeEnd);
        sb.append(", timezone=").append(timezone);
        sb.append(", amountTotal=").append(amountTotal);
        sb.append(", areas=").append(areas);
        sb.append(", currencies=").append(currencies);
        sb.append(", note=").append(note);
        sb.append(", createUid=").append(createUid);
        sb.append(", modifyUid=").append(modifyUid);
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