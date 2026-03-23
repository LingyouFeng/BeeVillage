package com.beevillage.search.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 笔记可见性
 *
 * @author Jason Feng
 * @since 2026-03-23 11:42
 */
@Getter
@AllArgsConstructor
public enum NoteVisibleEnum {

    PUBLIC(0), // 公开，所有人可见
    PRIVATE(1); // 仅自己可见

    private final Integer code;

}