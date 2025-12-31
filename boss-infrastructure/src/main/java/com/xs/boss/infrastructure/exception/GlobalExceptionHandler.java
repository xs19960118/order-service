package com.xs.boss.infrastructure.exception;

import com.xs.boss.infrastructure.enums.ErrorCodeEnum;
import com.xs.boss.infrastructure.security.JwtAuthenticationException;
import com.xs.xsbox.starter.exception.BaseGlobalExceptionHandler;
import com.xs.xsbox.starter.web.HttpResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 * <p>
 * 继承 BaseGlobalExceptionHandler 获得基础异常处理能力
 * 添加项目特定的异常处理逻辑，统一异常响应格式
 *
 * @author xiangshang
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends BaseGlobalExceptionHandler {

    /**
     * 处理 JWT 认证异常
     */
    @ExceptionHandler(JwtAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public HttpResponseEntity<?> handleJwtAuthenticationException(JwtAuthenticationException e, HttpServletRequest request) {
        log.warn("JWT 认证异常: {}, URI: {}", e.getMessage(), request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.UNAUTHORIZED.getCode(), e.getMessage());
    }

    /**
     * 处理 BossBusinessException 业务异常
     */
    @ExceptionHandler(BossBusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseEntity<?> handleBossBusinessException(BossBusinessException e, HttpServletRequest request) {
        log.warn("业务异常: code={}, message={}, URI: {}", e.getCode(), e.getMessage(), request.getRequestURI());
        return HttpResponseEntity.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理参数校验异常（@Valid 注解校验失败）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(error -> String.format("%s: %s", error.getField(), error.getDefaultMessage()))
                .collect(Collectors.joining("; "));
        log.warn("参数校验失败: {}, URI: {}", errorMessage, request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.VALIDATION_ERROR.getCode(), errorMessage);
    }

    /**
     * 处理参数绑定异常（表单数据绑定失败）
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseEntity<?> handleBindException(BindException e, HttpServletRequest request) {
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));
        log.warn("参数绑定失败: {}, URI: {}", errorMessage, request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.VALIDATION_ERROR.getCode(), errorMessage);
    }

    /**
     * 处理约束违反异常（@Validated 注解校验失败）
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        String errorMessage = violations.stream()
                .map(violation -> String.format("%s: %s", violation.getPropertyPath(), violation.getMessage()))
                .collect(Collectors.joining("; "));
        log.warn("约束违反异常: {}, URI: {}", errorMessage, request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.VALIDATION_ERROR.getCode(), errorMessage);
    }

    /**
     * 处理缺少请求参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest request) {
        String errorMessage = String.format("缺少必需参数: %s (类型: %s)", e.getParameterName(), e.getParameterType());
        log.warn("缺少请求参数: {}, URI: {}", errorMessage, request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.REQUIRED_PARAM_MISSING.getCode(), errorMessage);
    }

    /**
     * 处理参数类型不匹配异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        String errorMessage = String.format("参数类型不匹配: %s，期望类型: %s，实际值: %s",
                e.getName(), e.getRequiredType() != null ? e.getRequiredType().getSimpleName() : "未知", e.getValue());
        log.warn("参数类型不匹配: {}, URI: {}", errorMessage, request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.PARAM_FORMAT_ERROR.getCode(), errorMessage);
    }

    /**
     * 处理 HTTP 消息不可读异常（JSON 解析失败等）
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        log.warn("HTTP 消息不可读: {}, URI: {}", e.getMessage(), request.getRequestURI());
        String message = e.getMessage() != null && e.getMessage().contains("JSON") 
                ? "JSON 格式错误" 
                : "请求体格式错误";
        return HttpResponseEntity.fail(ErrorCodeEnum.PARAM_FORMAT_ERROR.getCode(), message);
    }

    /**
     * 处理 HTTP 方法不支持异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public HttpResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        String supportedMethods = String.join(", ", e.getSupportedMethods() != null ? e.getSupportedMethods() : new String[0]);
        String errorMessage = String.format("不支持的 HTTP 方法: %s，支持的方法: %s", e.getMethod(), supportedMethods);
        log.warn("HTTP 方法不支持: {}, URI: {}", errorMessage, request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.UNSUPPORTED_OPERATION.getCode(), errorMessage);
    }

    /**
     * 处理 404 异常（资源不存在）
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpResponseEntity<?> handleNoHandlerFoundException(NoHandlerFoundException e, HttpServletRequest request) {
        log.warn("资源不存在: {}, URI: {}", e.getRequestURL(), request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.DATA_NOT_FOUND.getCode(), "请求的资源不存在");
    }

    /**
     * 处理数据库重复键异常
     */
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseEntity<?> handleDuplicateKeyException(DuplicateKeyException e, HttpServletRequest request) {
        log.warn("数据重复: {}, URI: {}", e.getMessage(), request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.DATA_DUPLICATE.getCode(), ErrorCodeEnum.DATA_DUPLICATE.getMessage());
    }

    /**
     * 处理数据库访问异常
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseEntity<?> handleDataAccessException(DataAccessException e, HttpServletRequest request) {
        log.error("数据库访问异常: {}, URI: {}", e.getMessage(), request.getRequestURI(), e);
        return HttpResponseEntity.fail(ErrorCodeEnum.DATABASE_ERROR.getCode(), ErrorCodeEnum.DATABASE_ERROR.getMessage());
    }

    /**
     * 处理 SQL 异常
     */
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseEntity<?> handleSQLException(SQLException e, HttpServletRequest request) {
        log.error("SQL 异常: {}, URI: {}", e.getMessage(), request.getRequestURI(), e);
        return HttpResponseEntity.fail(ErrorCodeEnum.DATABASE_ERROR.getCode(), "数据库操作失败");
    }

    /**
     * 处理非法参数异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        log.warn("非法参数: {}, URI: {}", e.getMessage(), request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.PARAM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 处理非法状态异常
     */
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseEntity<?> handleIllegalStateException(IllegalStateException e, HttpServletRequest request) {
        log.warn("非法状态: {}, URI: {}", e.getMessage(), request.getRequestURI());
        return HttpResponseEntity.fail(ErrorCodeEnum.BUSINESS_ERROR.getCode(), e.getMessage());
    }

    /**
     * 处理所有未捕获的异常（兜底处理）
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResponseEntity<?> handleException(Exception e, HttpServletRequest request) {
        log.error("系统异常: {}, URI: {}", e.getMessage(), request.getRequestURI(), e);
        return HttpResponseEntity.fail(ErrorCodeEnum.SYSTEM_ERROR.getCode(), ErrorCodeEnum.SYSTEM_ERROR.getMessage());
    }
}