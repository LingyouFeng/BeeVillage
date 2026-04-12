package com.beevillage.count.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 评论点赞、取消点赞 Type
 *
 * @author Jason Feng
 * @since 2026-04-11 15:44
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

    public static LikeUnlikeCommentTypeEnum valueOf(Integer code) {
        for (LikeUnlikeCommentTypeEnum likeUnlikeCommentTypeEnum : LikeUnlikeCommentTypeEnum.values()) {
            if (Objects.equals(code, likeUnlikeCommentTypeEnum.getCode())) {
                return likeUnlikeCommentTypeEnum;
            }
        }
        return null;
    }
}