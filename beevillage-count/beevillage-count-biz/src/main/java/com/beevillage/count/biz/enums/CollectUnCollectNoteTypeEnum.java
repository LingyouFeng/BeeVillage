package com.beevillage.count.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 笔记收藏、取消收藏 Type
 *
 * @author Jason Feng
 * @since 2026-03-15 21:47
 */
@Getter
@AllArgsConstructor
public enum CollectUnCollectNoteTypeEnum {
    // 收藏
    COLLECT(1),
    // 取消收藏
    UN_COLLECT(0),
    ;

    private final Integer code;

    public static CollectUnCollectNoteTypeEnum valueOf(Integer code) {
        for (CollectUnCollectNoteTypeEnum collectUnCollectNoteTypeEnum : CollectUnCollectNoteTypeEnum.values()) {
            if (Objects.equals(code, collectUnCollectNoteTypeEnum.getCode())) {
                return collectUnCollectNoteTypeEnum;
            }
        }
        return null;
    }

}