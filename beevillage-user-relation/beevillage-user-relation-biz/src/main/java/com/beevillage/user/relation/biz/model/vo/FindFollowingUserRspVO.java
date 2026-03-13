package com.beevillage.user.relation.biz.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询关注列表
 *
 * @author Jason Feng
 * @since 2026-03-12 20:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindFollowingUserRspVO {

    private Long userId;

    private String avatar;

    private String nickname;

    private String introduction;

}
