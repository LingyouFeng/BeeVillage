package com.beevillage.count.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 笔记计数实体类
 *
 * @author Jason Feng
 * @since 2026-03-13 16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteCountDO {

    private Long id;

    private Long noteId;

    private Long likeTotal;

    private Long collectTotal;

    private Long commentTotal;
}