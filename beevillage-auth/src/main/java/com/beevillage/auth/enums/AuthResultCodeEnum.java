package com.beevillage.auth.enums;

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
public enum AuthResultCodeEnum implements BaseExceptionInterface {

    VERIFICATION_CODE_SEND_FREQUENTLY(1, "请求太频繁，请3分钟后再试"),
    VERIFICATION_CODE_ERROR(2, "验证码错误"),
    LOGIN_TYPE_ERROR(3, "登录类型错误"),
    USER_NOT_FOUND(4, "该用户不存在"),
    PHONE_OR_PASSWORD_ERROR(5, "手机号或密码错误"),
    LOGIN_FAIL(20005, "登录失败"),
    ;

    private final Integer code;
    private final String message;
}