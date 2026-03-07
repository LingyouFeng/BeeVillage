package com.beevillage.note.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 笔记发布
 *
 * @author Jason Feng
 * @since 2026-03-05 20:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublishNoteReqVO {

    @NotNull(message = "笔记类型不能为空")
    private Integer type;

    private List<String> imgUris;

    private String videoUri;

    private String title;

    private String content;

    private Long topicId;
}