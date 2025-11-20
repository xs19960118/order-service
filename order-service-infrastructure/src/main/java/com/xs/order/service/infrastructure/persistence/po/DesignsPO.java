package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 主数据-3D设计
 * @TableName designs
 */
@TableName(value ="designs")
@Data
public class DesignsPO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 病例编号
     */
    private String caseCode;

    /**
     * 设计单编号
     */
    private String code;

    /**
     * （矫治器）产品编号
     */
    private String productCode;

    /**
     * 难度 1.简单，2.一般，3.困难
     */
    private Integer difficulty;

    /**
     * 1.上颌，2.下颌，3.全颌
     */
    private Integer jaw;

    /**
     * 上一阶段确认的设计编号
     */
    private String previousCode;

    /**
     * 标签位 1.设计是否已确认, 2.是否是该产品首次确认, 4.是否包含mooeli
     */
    private Long labelBit;

    /**
     * 阶段创建时间
     */
    private Long timeStage;

    /**
     * 确认时间戳（秒）
     */
    private Long timeConfirm;

    /**
     * 消息投递时间
     */
    private Long timeAction;

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
        DesignsPO other = (DesignsPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCaseCode() == null ? other.getCaseCode() == null : this.getCaseCode().equals(other.getCaseCode()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getDifficulty() == null ? other.getDifficulty() == null : this.getDifficulty().equals(other.getDifficulty()))
            && (this.getJaw() == null ? other.getJaw() == null : this.getJaw().equals(other.getJaw()))
            && (this.getPreviousCode() == null ? other.getPreviousCode() == null : this.getPreviousCode().equals(other.getPreviousCode()))
            && (this.getLabelBit() == null ? other.getLabelBit() == null : this.getLabelBit().equals(other.getLabelBit()))
            && (this.getTimeStage() == null ? other.getTimeStage() == null : this.getTimeStage().equals(other.getTimeStage()))
            && (this.getTimeConfirm() == null ? other.getTimeConfirm() == null : this.getTimeConfirm().equals(other.getTimeConfirm()))
            && (this.getTimeAction() == null ? other.getTimeAction() == null : this.getTimeAction().equals(other.getTimeAction()))
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
        result = prime * result + ((getCaseCode() == null) ? 0 : getCaseCode().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getDifficulty() == null) ? 0 : getDifficulty().hashCode());
        result = prime * result + ((getJaw() == null) ? 0 : getJaw().hashCode());
        result = prime * result + ((getPreviousCode() == null) ? 0 : getPreviousCode().hashCode());
        result = prime * result + ((getLabelBit() == null) ? 0 : getLabelBit().hashCode());
        result = prime * result + ((getTimeStage() == null) ? 0 : getTimeStage().hashCode());
        result = prime * result + ((getTimeConfirm() == null) ? 0 : getTimeConfirm().hashCode());
        result = prime * result + ((getTimeAction() == null) ? 0 : getTimeAction().hashCode());
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
        sb.append(", caseCode=").append(caseCode);
        sb.append(", code=").append(code);
        sb.append(", productCode=").append(productCode);
        sb.append(", difficulty=").append(difficulty);
        sb.append(", jaw=").append(jaw);
        sb.append(", previousCode=").append(previousCode);
        sb.append(", labelBit=").append(labelBit);
        sb.append(", timeStage=").append(timeStage);
        sb.append(", timeConfirm=").append(timeConfirm);
        sb.append(", timeAction=").append(timeAction);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}