package com.beevillage.common.enums;

import com.beevillage.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态码枚举类
 *
 * @author Jason Feng
 * @since 2026-01-31 15:00
 */
@Getter
@AllArgsConstructor
public enum GlobalResultCodeEnum implements BaseExceptionInterface {

    // 成功状态
    SUCCESS(10000, "操作成功"),
    FAIL(10001, "操作失败"),

    METHOD_NOT_SUPPORTED(10002, "请求方法不支持"),
    CONTENT_TYPE_NOT_SUPPORTED(10003, "请求类型不支持"),
    REQUEST_FREQUENTLY(10004, "请求太频繁"),
    PARAM_ERROR(10005, "参数校验失败"),
    SYSTEM_ERROR(10006, "服务器内部异常，请稍后重试"),
    ;


    private final Integer code;
    private final String message;
}
