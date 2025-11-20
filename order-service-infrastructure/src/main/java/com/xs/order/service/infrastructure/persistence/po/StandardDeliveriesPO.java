package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单发货记录表
 * @TableName standard_deliveries
 */
@TableName(value ="standard_deliveries")
@Data
public class StandardDeliveriesPO implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * standard_deliveries.code
     */
    private String code;

    /**
     * 销售单据编号
     */
    private String processCode;

    /**
     * 销售单据编号类型
     */
    private Integer processCodeType;

    /**
     * pds_code_address
     */
    private String pdsCodeAddress;

    /**
     * pds_version_address
     */
    private Integer pdsVersionAddress;

    /**
     * pds_code_contact
     */
    private String pdsCodeContact;

    /**
     * pds_version_contact
     */
    private Integer pdsVersionContact;

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
        StandardDeliveriesPO other = (StandardDeliveriesPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getProcessCode() == null ? other.getProcessCode() == null : this.getProcessCode().equals(other.getProcessCode()))
            && (this.getProcessCodeType() == null ? other.getProcessCodeType() == null : this.getProcessCodeType().equals(other.getProcessCodeType()))
            && (this.getPdsCodeAddress() == null ? other.getPdsCodeAddress() == null : this.getPdsCodeAddress().equals(other.getPdsCodeAddress()))
            && (this.getPdsVersionAddress() == null ? other.getPdsVersionAddress() == null : this.getPdsVersionAddress().equals(other.getPdsVersionAddress()))
            && (this.getPdsCodeContact() == null ? other.getPdsCodeContact() == null : this.getPdsCodeContact().equals(other.getPdsCodeContact()))
            && (this.getPdsVersionContact() == null ? other.getPdsVersionContact() == null : this.getPdsVersionContact().equals(other.getPdsVersionContact()))
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
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getProcessCode() == null) ? 0 : getProcessCode().hashCode());
        result = prime * result + ((getProcessCodeType() == null) ? 0 : getProcessCodeType().hashCode());
        result = prime * result + ((getPdsCodeAddress() == null) ? 0 : getPdsCodeAddress().hashCode());
        result = prime * result + ((getPdsVersionAddress() == null) ? 0 : getPdsVersionAddress().hashCode());
        result = prime * result + ((getPdsCodeContact() == null) ? 0 : getPdsCodeContact().hashCode());
        result = prime * result + ((getPdsVersionContact() == null) ? 0 : getPdsVersionContact().hashCode());
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
        sb.append(", code=").append(code);
        sb.append(", processCode=").append(processCode);
        sb.append(", processCodeType=").append(processCodeType);
        sb.append(", pdsCodeAddress=").append(pdsCodeAddress);
        sb.append(", pdsVersionAddress=").append(pdsVersionAddress);
        sb.append(", pdsCodeContact=").append(pdsCodeContact);
        sb.append(", pdsVersionContact=").append(pdsVersionContact);
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