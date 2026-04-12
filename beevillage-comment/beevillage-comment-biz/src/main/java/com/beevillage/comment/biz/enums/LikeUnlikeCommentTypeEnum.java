package com.beevillage.comment.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 评论点赞、取消点赞 Type
 *
 * @author Jason Feng
 * @since 2026-03-31 20:16
 */
@Getter
@AllArgsConstructor
public enum LikeUnlikeCommentTypeEnum {
    // 点赞
    LIKE(1),
    // 取消点赞
    UNLIKE(0),
    ;

    private final Integer code;

}
