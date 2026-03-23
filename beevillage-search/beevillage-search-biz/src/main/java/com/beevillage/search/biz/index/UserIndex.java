package com.beevillage.search.biz.index;

/**
 * 用户索引
 *
 * @author Jason Feng
 * @since 2026-03-22 14:49
 */
public class UserIndex {

    /**
     * 索引名称
     */
    public static final String NAME = "user";

    /**
     * 用户 ID
     */
    public static final String FIELD_USER_ID = "id";

    /**
     * 昵称
     */
    public static final String FIELD_USER_NICKNAME = "nickname";

    /**
     * 头像
     */
    public static final String FIELD_USER_AVATAR = "avatar";

    /**
     * 蜜蜂村 ID
     */
    public static final String FIELD_USER_BEEVILLAGE_ID = "beevillage_id";

    /**
     * 发布笔记总数
     */
    public static final String FIELD_USER_NOTE_TOTAL = "note_total";

    /**
     * 粉丝总数
     */
    public static final String FIELD_USER_FANS_TOTAL = "fans_total";

}
