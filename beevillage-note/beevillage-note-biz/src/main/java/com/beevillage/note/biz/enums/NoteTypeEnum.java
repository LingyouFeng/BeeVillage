package com.beevillage.note.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 笔记类型
 *
 * @since 2026-03-04 22:22
 * @author Jason Feng
 */
@Getter
@AllArgsConstructor
public enum NoteTypeEnum {

    IMAGE_TEXT(0, "图文"),
    VIDEO(1, "视频");

    private final Integer code;
    private final String description;

    /**
     * 类型是否有效
     *
     * @param code  笔记类型码
     * @return      笔记类型是否有效
     */
    public static boolean isValid(Integer code) {
        for (NoteTypeEnum noteTypeEnum : NoteTypeEnum.values()) {
            if (Objects.equals(code, noteTypeEnum.getCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据类型 code 获取对应的枚举
     *
     * @param code  笔记类型码
     * @return      对应的枚举类型
     */
    public static NoteTypeEnum valueOf(Integer code) {
        for (NoteTypeEnum noteTypeEnum : NoteTypeEnum.values()) {
            if (Objects.equals(code, noteTypeEnum.getCode())) {
                return noteTypeEnum;
            }
        }
        return null;
    }
}
