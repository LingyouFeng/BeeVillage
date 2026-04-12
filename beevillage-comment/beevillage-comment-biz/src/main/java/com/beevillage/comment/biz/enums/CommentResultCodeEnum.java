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

    PARAM_NOT_VALID(10000, "参数无效"),
    COMMENT_NOT_FOUND(20000, "此评论不存在"),
    PARENT_COMMENT_NOT_FOUND(20001, "此父评论不存在"),
    COMMENT_ALREADY_LIKED(20002, "您已经点赞过该评论"),
    COMMENT_NOT_LIKED(20003, "您未点赞该评论，无法取消点赞"),
    COMMENT_CANT_OPERATE(20004, "您无法操作该评论"),
    ;

    private final Integer code;
    private final String message;
}