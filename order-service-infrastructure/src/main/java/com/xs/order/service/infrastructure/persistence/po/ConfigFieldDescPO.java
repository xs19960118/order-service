package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 字段描述,多语言
 * @TableName config_field_desc
 */
@TableName(value ="config_field_desc")
@Data
public class ConfigFieldDescPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 模块名(一个模块对应多个表)
     */
    private String module;

    /**
     * 字段名
     */
    private String field;

    /**
     * 值
     */
    private String val;

    /**
     * 中文描述
     */
    private String zhCn;

    /**
     * 英文描述
     */
    private String enUs;

    /**
     * 是否删除
     */
    private Integer deleted;

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
        ConfigFieldDescPO other = (ConfigFieldDescPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModule() == null ? other.getModule() == null : this.getModule().equals(other.getModule()))
            && (this.getField() == null ? other.getField() == null : this.getField().equals(other.getField()))
            && (this.getVal() == null ? other.getVal() == null : this.getVal().equals(other.getVal()))
            && (this.getZhCn() == null ? other.getZhCn() == null : this.getZhCn().equals(other.getZhCn()))
            && (this.getEnUs() == null ? other.getEnUs() == null : this.getEnUs().equals(other.getEnUs()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModule() == null) ? 0 : getModule().hashCode());
        result = prime * result + ((getField() == null) ? 0 : getField().hashCode());
        result = prime * result + ((getVal() == null) ? 0 : getVal().hashCode());
        result = prime * result + ((getZhCn() == null) ? 0 : getZhCn().hashCode());
        result = prime * result + ((getEnUs() == null) ? 0 : getEnUs().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", module=").append(module);
        sb.append(", field=").append(field);
        sb.append(", val=").append(val);
        sb.append(", zhCn=").append(zhCn);
        sb.append(", enUs=").append(enUs);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}