package com.xs.order.service.infrastructure.persistence.po.crm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 客户 PO 示例（CRM 数据源）
 * 
 * 这是一个示例 PO 对象，展示如何定义 CRM 数据源的持久化对象
 *
 * @author xiangshang
 */
@Data
@TableName("patients")
public class CustomerExamplePO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否VIP
     * 0-否，1-是
     */
    private Integer isVip;

    /**
     * 逻辑删除标识
     * 0-未删除，1-已删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}

