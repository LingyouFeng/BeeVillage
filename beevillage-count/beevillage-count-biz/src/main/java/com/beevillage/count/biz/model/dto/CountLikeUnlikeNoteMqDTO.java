package com.beevillage.count.biz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 点赞、取消点赞笔记
 *
 * @author Jason Feng
 * @since 2026-03-15 17:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountLikeUnlikeNoteMqDTO {

    private Long userId;

    private Long noteId;

    /**
     * 笔记发布者 ID
     */
    private Long noteCreatorId;

    /**
     * 0: 取消点赞， 1：点赞
     */
    private Integer type;

    private LocalDateTime createTime;
}