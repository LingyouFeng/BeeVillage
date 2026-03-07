package com.beevillage.note.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 笔记可见性
 *
 * @author Jason Feng
 * @since 2026-03-04 22:24
 */
@Getter
@AllArgsConstructor
public enum NoteVisibleEnum {

    // 公开，所有人可见
    PUBLIC(0),
    // 仅自己可见
    PRIVATE(1),
    ;
    private final Integer code;
}
