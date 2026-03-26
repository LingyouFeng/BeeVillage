package com.beevillage.comment.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 评论点赞实体类
 *
 * @since 2026-03-23 17:42
 * @author Jason Feng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentLikeDO {

    private Long id;

    private Long userId;

    private Long commentId;

    private LocalDateTime createTime;
}