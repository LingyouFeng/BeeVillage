package com.beevillage.gateway.enums;

import com.beevillage.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Jason Feng
 * @since 2026-02-07 16:18
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum implements BaseExceptionInterface {

    SYSTEM_ERROR(500, "服务器内部异常，请稍后重试"),
    UNAUTHORIZED(401, "权限不足");

    private final Integer code;
    private final String message;
}