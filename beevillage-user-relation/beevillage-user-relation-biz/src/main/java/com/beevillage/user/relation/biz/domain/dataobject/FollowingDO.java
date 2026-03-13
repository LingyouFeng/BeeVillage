package com.beevillage.user.relation.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 关注类
 *
 * @author Jason Feng
 * @since 2026-03-09 23:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowingDO {

    private Long id;

    private Long userId;

    private Long followingUserId;

    private LocalDateTime createTime;
}