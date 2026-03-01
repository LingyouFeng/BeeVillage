package com.beevillage.kv.biz.enums;

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
public enum KvResultCodeEnum implements BaseExceptionInterface {

    // ----------- 业务异常状态码 -----------
    NOTE_CONTENT_NOT_FOUND(20000, "该笔记内容不存在"),
    ;

    private final Integer code;
    private final String message;
}