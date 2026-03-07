package com.beevillage.note.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 频道话题关系实体类
 *
 * @since 2026-03-04 21:23
 * @author Jason Feng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelTopicRelDO {

    private Long id;

    private Long channelId;

    private Long topicId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}