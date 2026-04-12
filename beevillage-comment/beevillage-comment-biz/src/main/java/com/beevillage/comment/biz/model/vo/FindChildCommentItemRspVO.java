package com.beevillage.comment.biz.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询二级评论
 *
 * @author Jason Feng
 * @since 2026-03-29 20:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindChildCommentItemRspVO {

    /**
     * 评论 ID
     */
    private Long commentId;

    /**
     * 发布者用户 ID
     */
    private Long userId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论内容
     */
    private String imageUrl;

    /**
     * 发布时间
     */
    private String createTime;

    /**
     * 被点赞数
     */
    private Long likeTotal;

    /**
     * 回复的用户昵称
     */
    private String replyUserName;

    /**
     * 回复的用户 ID
     */
    private Long replyUserId;
}
