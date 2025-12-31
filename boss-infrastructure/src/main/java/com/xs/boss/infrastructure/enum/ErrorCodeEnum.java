package com.xs.boss.infrastructure.enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码枚举
 * <p>
 * 统一管理系统中所有错误码和错误消息
 * 错误码规则：
 * - 1xxxx: 通用错误
 * - 2xxxx: 认证授权相关错误
 * - 3xxxx: 业务逻辑错误
 * - 4xxxx: 参数校验错误
 * - 5xxxx: 数据操作错误
 * - 9xxxx: 系统内部错误
 *
 * @author xiangshang
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    // ========== 通用错误 1xxxx ==========
    /**
     * 操作成功
     */
    SUCCESS(10000, "操作成功"),

    /**
     * 操作失败
     */
    FAIL(10001, "操作失败"),

    /**
     * 系统繁忙，请稍后重试
     */
    SYSTEM_BUSY(10002, "系统繁忙，请稍后重试"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(10003, "系统异常"),

    /**
     * 参数错误
     */
    PARAM_ERROR(10004, "参数错误"),

    /**
     * 数据不存在
     */
    DATA_NOT_FOUND(10005, "数据不存在"),

    /**
     * 数据已存在
     */
    DATA_ALREADY_EXISTS(10006, "数据已存在"),

    /**
     * 操作超时
     */
    OPERATION_TIMEOUT(10007, "操作超时"),

    /**
     * 不支持的操作
     */
    UNSUPPORTED_OPERATION(10008, "不支持的操作"),

    // ========== 认证授权相关错误 2xxxx ==========
    /**
     * 未登录或Token已过期
     */
    UNAUTHORIZED(20001, "未登录或Token已过期"),

    /**
     * Token无效
     */
    TOKEN_INVALID(20002, "Token无效"),

    /**
     * Token已过期
     */
    TOKEN_EXPIRED(20003, "Token已过期"),

    /**
     * Token格式错误
     */
    TOKEN_MALFORMED(20004, "Token格式错误"),

    /**
     * Token签名验证失败
     */
    TOKEN_SIGNATURE_INVALID(20005, "Token签名验证失败"),

    /**
     * 无权限访问
     */
    FORBIDDEN(20006, "无权限访问"),

    /**
     * 用户名或密码错误
     */
    LOGIN_FAILED(20007, "用户名或密码错误"),

    /**
     * 账号已被禁用
     */
    ACCOUNT_DISABLED(20008, "账号已被禁用"),

    /**
     * 账号已被锁定
     */
    ACCOUNT_LOCKED(20009, "账号已被锁定"),

    // ========== 业务逻辑错误 3xxxx ==========
    /**
     * 业务处理失败
     */
    BUSINESS_ERROR(30001, "业务处理失败"),

    /**
     * 订单不存在
     */
    ORDER_NOT_FOUND(30002, "订单不存在"),

    /**
     * 订单状态不正确
     */
    ORDER_STATUS_ERROR(30003, "订单状态不正确"),

    /**
     * 库存不足
     */
    INSUFFICIENT_STOCK(30004, "库存不足"),

    /**
     * 余额不足
     */
    INSUFFICIENT_BALANCE(30005, "余额不足"),

    // ========== 参数校验错误 4xxxx ==========
    /**
     * 参数校验失败
     */
    VALIDATION_ERROR(40001, "参数校验失败"),

    /**
     * 必填参数缺失
     */
    REQUIRED_PARAM_MISSING(40002, "必填参数缺失"),

    /**
     * 参数格式错误
     */
    PARAM_FORMAT_ERROR(40003, "参数格式错误"),

    /**
     * 参数值超出范围
     */
    PARAM_OUT_OF_RANGE(40004, "参数值超出范围"),

    // ========== 数据操作错误 5xxxx ==========
    /**
     * 数据库操作失败
     */
    DATABASE_ERROR(50001, "数据库操作失败"),

    /**
     * 数据保存失败
     */
    DATA_SAVE_FAILED(50002, "数据保存失败"),

    /**
     * 数据更新失败
     */
    DATA_UPDATE_FAILED(50003, "数据更新失败"),

    /**
     * 数据删除失败
     */
    DATA_DELETE_FAILED(50004, "数据删除失败"),

    /**
     * 数据查询失败
     */
    DATA_QUERY_FAILED(50005, "数据查询失败"),

    /**
     * 数据重复
     */
    DATA_DUPLICATE(50006, "数据重复"),

    // ========== 系统内部错误 9xxxx ==========
    /**
     * 内部服务错误
     */
    INTERNAL_SERVER_ERROR(90001, "内部服务错误"),

    /**
     * 外部服务调用失败
     */
    EXTERNAL_SERVICE_ERROR(90002, "外部服务调用失败"),

    /**
     * Redis操作失败
     */
    REDIS_ERROR(90003, "Redis操作失败"),

    /**
     * 消息队列操作失败
     */
    MQ_ERROR(90004, "消息队列操作失败"),

    /**
     * 文件操作失败
     */
    FILE_OPERATION_ERROR(90005, "文件操作失败");

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误消息
     */
    private final String message;

    /**
     * 根据错误码获取枚举
     *
     * @param code 错误码
     * @return 错误码枚举
     */
    public static ErrorCodeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ErrorCodeEnum errorCodeEnum : values()) {
            if (errorCodeEnum.getCode().equals(code)) {
                return errorCodeEnum;
            }
        }
        return null;
    }

    /**
     * 判断错误码是否存在
     *
     * @param code 错误码
     * @return 是否存在
     */
    public static boolean exists(Integer code) {
        return getByCode(code) != null;
    }
}

