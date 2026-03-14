package com.beevillage.user.relation.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 关注、取关 Type
 *
 * @author Jason Feng
 * @since 2026-03-13 17:22
 */
@Getter
@AllArgsConstructor
public enum FollowUnfollowTypeEnum {
    // 关注
    FOLLOW(1),
    // 取关
    UNFOLLOW(0),
    ;

    private final Integer code;

}
