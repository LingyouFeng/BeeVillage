package com.beevillage.comment.biz.enums;

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
public enum CommentResultCodeEnum implements BaseExceptionInterface {

    ;

    private final Integer code;
    private final String message;
}