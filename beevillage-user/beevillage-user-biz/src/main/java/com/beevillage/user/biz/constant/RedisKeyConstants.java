package com.beevillage.user.biz.constant;

/**
 * Redis Key 常量类
 *
 * @author Jason Feng
 * @since 2026-02-01 11:19
 */
public class RedisKeyConstants {

    /**
     * 用户角色数据 KEY 前缀
     */
    private static final String USER_ROLES_KEY_PREFIX = "user:roles:";

    /**
     * 角色对应的权限集合 KEY 前缀
     */
    private static final String ROLE_PERMISSIONS_KEY_PREFIX = "role:permissions:";

    /**
     * 用户信息数据 KEY 前缀
     */
    private static final String USER_INFO_KEY_PREFIX = "user:info:";

    /**
     * 构建用户-角色 Key
     * @param userId    用户 id
     * @return          拼接手机号后的 redis key
     */
    public static String buildUserRoleKey(Long userId) {
        return USER_ROLES_KEY_PREFIX + userId;
    }

    /**
     * 构建角色对应的权限集合 KEY
     * @param roleKey   角色
     * @return          拼接角色后的 redis key
     */
    public static String buildRolePermissionsKey(String roleKey) {
        return ROLE_PERMISSIONS_KEY_PREFIX + roleKey;
    }

    /**
     * 构建角色对应的权限集合 KEY
     * @param userId    用户 id
     * @return          拼接用户 id 后的 redis key
     */
    public static String buildUserInfoKey(Long userId) {
        return USER_INFO_KEY_PREFIX + userId;
    }
}
