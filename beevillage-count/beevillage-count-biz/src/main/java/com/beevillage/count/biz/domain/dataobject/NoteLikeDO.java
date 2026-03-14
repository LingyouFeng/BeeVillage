package com.beevillage.count.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 笔记点赞实体类
 *
 * @author Jason Feng
 * @since 2026-03-13 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteLikeDO {

    private Long id;

    private Long userId;

    private Long noteId;

    private LocalDateTime createTime;

    private Integer status;
}