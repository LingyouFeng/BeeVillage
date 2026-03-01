package com.beevillage.auth.constant;

/**
 * Redis Key 常量类
 *
 * @author Jason Feng
 * @since 2026-02-01 11:19
 */
public class RedisKeyConstants {

    /**
     * 验证码 KEY 前缀
     */
    private static final String VERIFICATION_CODE_KEY_PREFIX = "verification_code:";

    /**
     * 构建验证码 KEY
     * @param phone     用户手机号
     * @return          拼接手机号后的 redis key
     */
    public static String buildVerificationCodeKey(String phone) {
        return VERIFICATION_CODE_KEY_PREFIX + phone;
    }
}
