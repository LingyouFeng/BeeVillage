package com.beevillage.user.relation.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 取关用户
 *
 * @author Jason Feng
 * @since 2026-03-12 11:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnfollowUserReqVO {

    @NotNull(message = "被取关用户 ID 不能为空")
    private Long unfollowUserId;
}