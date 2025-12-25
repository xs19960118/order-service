package com.xs.boss.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 当前登录用户领域模型
 *
 * @author xiangshang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUser implements Serializable {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色（可选）
     */
    private String role;

    /**
     * 部门ID（可选）
     */
    private Long departmentId;

    /**
     * 是否是超级管理员
     */
    private Boolean isAdmin;
}

