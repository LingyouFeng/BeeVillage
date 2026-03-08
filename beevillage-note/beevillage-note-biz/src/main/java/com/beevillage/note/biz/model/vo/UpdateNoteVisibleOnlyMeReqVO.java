package com.beevillage.note.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 笔记仅对自己可见
 *
 * @author Jason Feng
 * @since 2026-03-08 21:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateNoteVisibleOnlyMeReqVO {

    @NotNull(message = "笔记 ID 不能为空")
    private Long id;

}