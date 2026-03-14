package com.beevillage.count.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户计数实体类
 *
 * @author Jason Feng
 * @since 2026-03-13 17:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCountDO {

    private Long id;

    private Long userId;

    private Long fansTotal;

    private Long followingTotal;

    private Long noteTotal;

    private Long likeTotal;

    private Long collectTotal;
}