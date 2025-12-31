package com.xs.boss.infrastructure.exception;

import com.xs.boss.infrastructure.enums.ErrorCodeEnum;
import com.xs.xsbox.starter.exception.BusinessException;
import lombok.Getter;

/**
 * Boss 业务异常
 * <p>
 * 继承自 BusinessException，支持 ErrorCodeEnum 枚举
 * 提供更便捷的异常创建方式
 *
 * @author xiangshang
 */
@Getter
public class BossBusinessException extends BusinessException {

    /**
     * 错误码枚举
     */
    private final ErrorCodeEnum errorCodeEnum;

    /**
     * 使用错误消息创建异常
     *
     * @param message 错误消息
     */
    public BossBusinessException(String message) {
        super(message);
        this.errorCodeEnum = ErrorCodeEnum.BUSINESS_ERROR;
    }

    /**
     * 使用错误码和错误消息创建异常
     *
     * @param code    错误码
     * @param message 错误消息
     */
    public BossBusinessException(Integer code, String message) {
        super(code, message);
        this.errorCodeEnum = ErrorCodeEnum.getByCode(code);
    }

    /**
     * 使用错误码、错误消息和原因创建异常
     *
     * @param code    错误码
     * @param message 错误消息
     * @param cause   原因
     */
    public BossBusinessException(Integer code, String message, Throwable cause) {
        super(code, message, cause);
        this.errorCodeEnum = ErrorCodeEnum.getByCode(code);
    }

    /**
     * 使用错误消息和原因创建异常
     *
     * @param message 错误消息
     * @param cause   原因
     */
    public BossBusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCodeEnum = ErrorCodeEnum.BUSINESS_ERROR;
    }

    /**
     * 使用错误码枚举创建异常
     *
     * @param errorCodeEnum 错误码枚举
     */
    public BossBusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
    }

    /**
     * 使用错误码枚举和自定义消息创建异常
     *
     * @param errorCodeEnum 错误码枚举
     * @param message       自定义错误消息
     */
    public BossBusinessException(ErrorCodeEnum errorCodeEnum, String message) {
        super(errorCodeEnum.getCode(), message);
        this.errorCodeEnum = errorCodeEnum;
    }

    /**
     * 使用错误码枚举和原因创建异常
     *
     * @param errorCodeEnum 错误码枚举
     * @param cause         原因
     */
    public BossBusinessException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getCode(), errorCodeEnum.getMessage(), cause);
        this.errorCodeEnum = errorCodeEnum;
    }

    /**
     * 使用错误码枚举、自定义消息和原因创建异常
     *
     * @param errorCodeEnum 错误码枚举
     * @param message       自定义错误消息
     * @param cause         原因
     */
    public BossBusinessException(ErrorCodeEnum errorCodeEnum, String message, Throwable cause) {
        super(errorCodeEnum.getCode(), message, cause);
        this.errorCodeEnum = errorCodeEnum;
    }

    /**
     * 快速创建数据不存在异常
     *
     * @return BossBusinessException
     */
    public static BossBusinessException dataNotFound() {
        return new BossBusinessException(ErrorCodeEnum.DATA_NOT_FOUND);
    }

    /**
     * 快速创建数据不存在异常（带自定义消息）
     *
     * @param message 自定义消息
     * @return BossBusinessException
     */
    public static BossBusinessException dataNotFound(String message) {
        return new BossBusinessException(ErrorCodeEnum.DATA_NOT_FOUND, message);
    }

    /**
     * 快速创建数据已存在异常
     *
     * @return BossBusinessException
     */
    public static BossBusinessException dataAlreadyExists() {
        return new BossBusinessException(ErrorCodeEnum.DATA_ALREADY_EXISTS);
    }

    /**
     * 快速创建数据已存在异常（带自定义消息）
     *
     * @param message 自定义消息
     * @return BossBusinessException
     */
    public static BossBusinessException dataAlreadyExists(String message) {
        return new BossBusinessException(ErrorCodeEnum.DATA_ALREADY_EXISTS, message);
    }

    /**
     * 快速创建参数错误异常
     *
     * @param message 错误消息
     * @return BossBusinessException
     */
    public static BossBusinessException paramError(String message) {
        return new BossBusinessException(ErrorCodeEnum.PARAM_ERROR, message);
    }

    /**
     * 快速创建业务错误异常
     *
     * @param message 错误消息
     * @return BossBusinessException
     */
    public static BossBusinessException businessError(String message) {
        return new BossBusinessException(ErrorCodeEnum.BUSINESS_ERROR, message);
    }
}
