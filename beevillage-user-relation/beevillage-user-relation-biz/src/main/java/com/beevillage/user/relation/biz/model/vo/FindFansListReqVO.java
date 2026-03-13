package com.beevillage.user.relation.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询粉丝列表
 *
 * @author Jason Feng
 * @since 2026-03-12 22:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindFansListReqVO {

    @NotNull(message = "查询用户 ID 不能为空")
    private Long userId;

    @NotNull(message = "页码不能为空")
    private Integer pageNo = 1; // 默认值为第一页
}