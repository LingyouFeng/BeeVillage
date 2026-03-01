package com.beevillage.user.biz.enums;

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
public enum UserResultCodeEnum implements BaseExceptionInterface {

    // ----------- 业务异常状态码 -----------
    NICK_NAME_VALID_FAIL(20001, "昵称请设置2-24个字符，不能使用@《/等特殊字符"),
    BEEVILLAGE_ID_VALID_FAIL(20002, "用户id请设置6-15个字符，仅可使用英文（必须）、数字、下划线"),
    SEX_VALID_FAIL(20003, "性别错误"),
    INTRODUCTION_VALID_FAIL(20004, "个人简介请设置1-100个字符"),
    UPLOAD_AVATAR_FAIL(20005, "头像上传失败"),
    UPLOAD_BACKGROUND_IMG_FAIL(20006, "背景图上传失败"),
    USER_NOT_FOUND(20007, "该用户不存在"),
    ;

    private final Integer code;
    private final String message;
}