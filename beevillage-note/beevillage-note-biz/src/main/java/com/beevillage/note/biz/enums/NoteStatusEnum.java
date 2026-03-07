package com.beevillage.note.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 笔记状态
 *
 * @author Jason Feng
 * @since 2026-03-04 22:23
 */
@Getter
@AllArgsConstructor
public enum NoteStatusEnum {

    // 待审核
    BE_EXAMINE(0),
    // 正常展示
    NORMAL(1),
    // 被删除
    DELETED(2),
    // 被下架
    DOWNED(3),
    ;

    private final Integer code;

}