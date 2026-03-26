package com.beevillage.comment.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 评论实体类
 *
 * @since 2026-03-23 17:42
 * @author Jason Feng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDO {

    private Long id;

    private Long noteId;

    private Long userId;

    private String contentUuid;

    private Boolean isContentEmpty;

    private String imageUrl;

    private Integer level;

    private Long replyTotal;

    private Long likeTotal;

    private Long parentId;

    private Long replyCommentId;

    private Long replyUserId;

    private Boolean isTop;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}