package com.beevillage.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jason Feng
 * @since 2026-01-31 17:45
 */
@Getter
@Setter
public class BusinessException extends RuntimeException implements BaseExceptionInterface {
    // 异常码
    private Integer code;
    // 错误信息
    private String message;

    public BusinessException(BaseExceptionInterface baseExceptionInterface) {
        this.code = baseExceptionInterface.getCode();
        this.message = baseExceptionInterface.getMessage();
    }
}
