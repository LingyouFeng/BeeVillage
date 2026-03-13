package com.beevillage.user.relation.biz.constant;

/**
 * MQ 常量
 *
 * @author Jason Feng
 * @since 2026-03-11 19:42
 */
public interface MQConstants {

    /**
     * Topic: 关注、取关共用一个
     */
    String TOPIC_FOLLOW_OR_UNFOLLOW = "FollowUnfollowTopic";

    /**
     * 关注标签
     */
    String TAG_FOLLOW = "Follow";

    /**
     * 取关标签
     */
    String TAG_UNFOLLOW = "Unfollow";
}
