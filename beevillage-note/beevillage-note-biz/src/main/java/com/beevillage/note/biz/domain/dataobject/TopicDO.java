package com.beevillage.note.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 话题实体类
 *
 * @since 2026-03-04 21:23
 * @author Jason Feng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicDO {

    private Long id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;
}