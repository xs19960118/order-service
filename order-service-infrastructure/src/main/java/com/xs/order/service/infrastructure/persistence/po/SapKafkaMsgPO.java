package com.xs.order.service.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * SAP消息通知
 * @TableName sap_kafka_msg
 */
@TableName(value ="sap_kafka_msg")
@Data
public class SapKafkaMsgPO implements Serializable {
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 消息ID
     */
    private String msgId;

    /**
     * 事件名
     */
    private String eventName;

    /**
     * 事件状态 0:待发布 1:发布成功 2:发布中 3:发布失败 4:待重新发布
     */
    private Integer status;

    /**
     * 事件key
     */
    private String eventKey;

    /**
     * traceId
     */
    private String traceId;

    /**
     * 事件业务参数
     */
    private String eventParam;

    /**
     * 事件非业务属性
     */
    private String eventProperty;

    /**
     * 事件时间
     */
    private Long timestamp;

    /**
     * 偏移量
     */
    private Long offset;

    /**
     * 分区
     */
    private Integer partition;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date updated;

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
        SapKafkaMsgPO other = (SapKafkaMsgPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()))
            && (this.getEventName() == null ? other.getEventName() == null : this.getEventName().equals(other.getEventName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getEventKey() == null ? other.getEventKey() == null : this.getEventKey().equals(other.getEventKey()))
            && (this.getTraceId() == null ? other.getTraceId() == null : this.getTraceId().equals(other.getTraceId()))
            && (this.getEventParam() == null ? other.getEventParam() == null : this.getEventParam().equals(other.getEventParam()))
            && (this.getEventProperty() == null ? other.getEventProperty() == null : this.getEventProperty().equals(other.getEventProperty()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getOffset() == null ? other.getOffset() == null : this.getOffset().equals(other.getOffset()))
            && (this.getPartition() == null ? other.getPartition() == null : this.getPartition().equals(other.getPartition()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMsgId() == null) ? 0 : getMsgId().hashCode());
        result = prime * result + ((getEventName() == null) ? 0 : getEventName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getEventKey() == null) ? 0 : getEventKey().hashCode());
        result = prime * result + ((getTraceId() == null) ? 0 : getTraceId().hashCode());
        result = prime * result + ((getEventParam() == null) ? 0 : getEventParam().hashCode());
        result = prime * result + ((getEventProperty() == null) ? 0 : getEventProperty().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getOffset() == null) ? 0 : getOffset().hashCode());
        result = prime * result + ((getPartition() == null) ? 0 : getPartition().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getUpdated() == null) ? 0 : getUpdated().hashCode());
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
        sb.append(", msgId=").append(msgId);
        sb.append(", eventName=").append(eventName);
        sb.append(", status=").append(status);
        sb.append(", eventKey=").append(eventKey);
        sb.append(", traceId=").append(traceId);
        sb.append(", eventParam=").append(eventParam);
        sb.append(", eventProperty=").append(eventProperty);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", offset=").append(offset);
        sb.append(", partition=").append(partition);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}