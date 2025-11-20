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
 * @TableName failed_jobs
 */
@TableName(value ="failed_jobs")
@Data
public class FailedJobsPO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 链接名
     */
    private String connection;

    /**
     * queue的名字
     */
    private String queue;

    /**
     * job_id
     */
    private String jobId;

    /**
     * 
     */
    private String payload;

    /**
     * 
     */
    private String exception;

    /**
     * 
     */
    private Date failedAt;

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
        FailedJobsPO other = (FailedJobsPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getConnection() == null ? other.getConnection() == null : this.getConnection().equals(other.getConnection()))
            && (this.getQueue() == null ? other.getQueue() == null : this.getQueue().equals(other.getQueue()))
            && (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getPayload() == null ? other.getPayload() == null : this.getPayload().equals(other.getPayload()))
            && (this.getException() == null ? other.getException() == null : this.getException().equals(other.getException()))
            && (this.getFailedAt() == null ? other.getFailedAt() == null : this.getFailedAt().equals(other.getFailedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getConnection() == null) ? 0 : getConnection().hashCode());
        result = prime * result + ((getQueue() == null) ? 0 : getQueue().hashCode());
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getPayload() == null) ? 0 : getPayload().hashCode());
        result = prime * result + ((getException() == null) ? 0 : getException().hashCode());
        result = prime * result + ((getFailedAt() == null) ? 0 : getFailedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", connection=").append(connection);
        sb.append(", queue=").append(queue);
        sb.append(", jobId=").append(jobId);
        sb.append(", payload=").append(payload);
        sb.append(", exception=").append(exception);
        sb.append(", failedAt=").append(failedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}