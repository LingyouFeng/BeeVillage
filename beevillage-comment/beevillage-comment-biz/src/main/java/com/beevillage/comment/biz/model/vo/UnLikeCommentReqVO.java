package com.beevillage.comment.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 取消评论点赞
 *
 * @author Jason Feng
 * @since 2026-04-01 11:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnLikeCommentReqVO {

    @NotNull(message = "评论 ID 不能为空")
    private Long commentId;

}