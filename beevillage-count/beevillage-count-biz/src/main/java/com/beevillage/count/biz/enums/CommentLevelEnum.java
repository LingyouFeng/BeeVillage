package com.beevillage.count.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 评论级别
 *
 * @author Jason Feng
 * @since 2026-03-27 11:43
 */
@Getter
@AllArgsConstructor
public enum CommentLevelEnum {
    // 一级评论
    ONE(1),
    // 二级评论
    TWO(2),
    ;

    private final Integer code;

}
