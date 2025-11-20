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
 * @TableName data_job
 */
@TableName(value ="data_job")
@Data
public class DataJobPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * data_batch.id
     */
    private Long batchId;

    /**
     * excel文件的行号
     */
    private Integer line;

    /**
     * payload的json
     */
    private String payloadJson;

    /**
     * 状态 0.待处理, 10.已取消, 1.处理中, 2.完成, 3.失败
     */
    private Integer status;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 结果信息的json
     */
    private String resultJson;

    /**
     * 乐观锁版本号
     */
    private Integer version;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Long deleteTime;

    /**
     * payload序列化
     */
    private String payload;

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
        DataJobPO other = (DataJobPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBatchId() == null ? other.getBatchId() == null : this.getBatchId().equals(other.getBatchId()))
            && (this.getLine() == null ? other.getLine() == null : this.getLine().equals(other.getLine()))
            && (this.getPayloadJson() == null ? other.getPayloadJson() == null : this.getPayloadJson().equals(other.getPayloadJson()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getError() == null ? other.getError() == null : this.getError().equals(other.getError()))
            && (this.getResultJson() == null ? other.getResultJson() == null : this.getResultJson().equals(other.getResultJson()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getPayload() == null ? other.getPayload() == null : this.getPayload().equals(other.getPayload()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBatchId() == null) ? 0 : getBatchId().hashCode());
        result = prime * result + ((getLine() == null) ? 0 : getLine().hashCode());
        result = prime * result + ((getPayloadJson() == null) ? 0 : getPayloadJson().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getError() == null) ? 0 : getError().hashCode());
        result = prime * result + ((getResultJson() == null) ? 0 : getResultJson().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getPayload() == null) ? 0 : getPayload().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", batchId=").append(batchId);
        sb.append(", line=").append(line);
        sb.append(", payloadJson=").append(payloadJson);
        sb.append(", status=").append(status);
        sb.append(", error=").append(error);
        sb.append(", resultJson=").append(resultJson);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", payload=").append(payload);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}