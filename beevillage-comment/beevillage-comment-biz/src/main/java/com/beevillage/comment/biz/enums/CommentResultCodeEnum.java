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

    COMMENT_NOT_FOUND(20001, "此评论不存在"),
    ;

    private final Integer code;
    private final String message;
}