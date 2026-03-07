package com.beevillage.note.biz.exception;

import com.beevillage.common.enums.GlobalResultCodeEnum;
import com.beevillage.common.exception.BusinessException;
import com.beevillage.common.response.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

/**
 *
 * @since 2026-01-31 15:41
 * @author Jason Feng
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获请求方式不支持异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<?> handleHttpRequestMethodNotSupported(HttpServletRequest request,
                                                         HttpRequestMethodNotSupportedException e) {
        log.warn("请求地址'{}'不支持'{}'方法请求！", request.getRequestURI(), e.getMethod());
        return Result.fail(GlobalResultCodeEnum.METHOD_NOT_SUPPORTED);
    }

    /**
     * 捕获请求类型不支持异常
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result<?> handleHttpMediaTypeNotSupported(HttpServletRequest request,
                                                     HttpMediaTypeNotSupportedException e) {
        log.warn("请求地址'{}'不支持'{}'类型请求！", request.getRequestURI(), e.getContentType());
        return Result.fail(GlobalResultCodeEnum.METHOD_NOT_SUPPORTED);
    }

    /**
     * 捕获参数校验异常
     */
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public Result<?> handleMethodArgumentNotValidException(HttpServletRequest request,
                                                           MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();

        // 只获取第一个校验不通过的字段，格式为： email 邮箱格式不正确, 当前值: '123124qq.com';
        Optional.of(bindingResult.getFieldErrors())
                .filter(errors -> !errors.isEmpty())
                .map(errors -> errors.get(0))
                .ifPresent(error ->
                        sb.append(error.getField())
                                .append(error.getDefaultMessage())
                                .append(", 当前值为")
                                .append(error.getRejectedValue())
                );
        String errorMessage = sb.toString();
        log.warn("请求地址'{}'入参校验失败！", request.getRequestURI());
        return Result.fail(GlobalResultCodeEnum.PARAM_ERROR, errorMessage);
    }

    /**
     * 捕获 guava 参数校验异常
     */
    @ExceptionHandler({ IllegalArgumentException.class })
    public Result<?> handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        log.warn("请求地址'{}'参数校验失败！", request.getRequestURI());
        return Result.fail(GlobalResultCodeEnum.PARAM_ERROR,  e.getMessage());
    }

    /**
     * 捕获业务异常
     */
    @ExceptionHandler({ BusinessException.class })
    public Result<?> handleBusinessException(HttpServletRequest request, BusinessException e) {
        log.warn("请求地址'{}'业务处理失败！", request.getRequestURI());
        return Result.fail(e);
    }

    /**
     * 捕获兜底异常
     */
    @ExceptionHandler({ Exception.class })
    public Result<?> handleException(HttpServletRequest request, Exception e) {
        log.error("请求地址'{}'发生系统异常！", request.getRequestURI(), e);
        return Result.fail(GlobalResultCodeEnum.SYSTEM_ERROR);
    }
}
