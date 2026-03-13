package com.beevillage.user.relation.biz.enums;

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
public enum RelationResultCodeEnum implements BaseExceptionInterface {

    // ----------- 业务异常状态码 -----------
    CANT_FOLLOW_YOUR_SELF(20001, "无法关注自己"),
    FOLLOW_USER_NOT_EXISTED(20002, "关注的用户不存在"),
    FOLLOWING_COUNT_LIMIT(20003, "您关注的用户已达上限，请先取关部分用户"),
    ALREADY_FOLLOWED(20004, "您已经关注了该用户"),
    CANT_UNFOLLOW_YOUR_SELF(20005, "无法取关自己"),
    NOT_FOLLOWED(20006, "你未关注对方，无法取关"),
    ;

    private final Integer code;
    private final String message;
}