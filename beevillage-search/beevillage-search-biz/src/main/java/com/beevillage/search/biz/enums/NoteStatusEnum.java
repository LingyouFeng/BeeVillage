package com.beevillage.search.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 笔记状态
 *
 * @author Jason Feng
 * @since 2026-03-23 11:41
 */
@Getter
@AllArgsConstructor
public enum NoteStatusEnum {

    BE_EXAMINE(0), // 待审核
    NORMAL(1), // 正常展示
    DELETED(2), // 被删除
    DOWNED(3), // 被下架
    ;

    private final Integer code;

}
