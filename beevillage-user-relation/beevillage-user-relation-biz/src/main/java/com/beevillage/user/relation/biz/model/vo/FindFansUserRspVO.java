package com.beevillage.user.relation.biz.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询粉丝列表
 *
 * @author Jason Feng
 * @since 2026-03-12 22:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindFansUserRspVO {

    /**
     * 用户 ID
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
     * 粉丝总数
     */
    private Long fansTotal;

    /**
     * 笔记总数
     */
    private Long noteTotal;

}