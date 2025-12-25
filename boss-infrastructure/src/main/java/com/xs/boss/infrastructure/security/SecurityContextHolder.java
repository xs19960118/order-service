package com.xs.boss.infrastructure.security;

import com.xs.boss.domain.user.model.CurrentUser;

/**
 * 安全上下文持有者
 * 使用 ThreadLocal 存储当前请求的用户信息
 *
 * @author xiangshang
 */
public class SecurityContextHolder {

    private static final ThreadLocal<CurrentUser> CONTEXT = new ThreadLocal<>();

    /**
     * 设置当前用户
     */
    public static void setCurrentUser(CurrentUser user) {
        CONTEXT.set(user);
    }

    /**
     * 获取当前用户
     */
    public static CurrentUser getCurrentUser() {
        return CONTEXT.get();
    }

    /**
     * 获取当前用户ID
     */
    public static Long getCurrentUserId() {
        CurrentUser user = getCurrentUser();
        return user != null ? user.getUserId() : null;
    }

    /**
     * 清除当前用户（请求结束时必须调用，避免内存泄漏）
     */
    public static void clear() {
        CONTEXT.remove();
    }

    /**
     * 判断是否已登录
     */
    public static boolean isAuthenticated() {
        return getCurrentUser() != null;
    }
}

