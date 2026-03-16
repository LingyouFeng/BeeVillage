package com.beevillage.note.biz.enums;

import com.beevillage.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Jason Feng
 * @since 2026-02-07 16:18
 */
@Getter
@AllArgsConstructor
public enum NoteResultCodeEnum implements BaseExceptionInterface {

    NOTE_TYPE_ERROR(20000, "未知的笔记类型"),
    NOTE_PUBLISH_FAIL(20001, "笔记发布失败"),
    NOTE_NOT_FOUND(20002, "笔记不存在"),
    NOTE_PRIVATE(20003, "作者已将该笔记设置为仅自己可见"),
    NOTE_UPDATE_FAIL(20004, "笔记更新失败"),
    TOPIC_NOT_FOUND(20005, "话题不存在"),
    NOTE_CANT_VISIBLE_ONLY_ME(20006, "此笔记无法修改为仅自己可见"),
    NOTE_CANT_OPERATE(20007, "您无法操作该笔记"),
    NOTE_ALREADY_LIKED(20008, "您已经点赞过该笔记"),
    NOTE_NOT_LIKED(20009, "您未点赞该篇笔记，无法取消点赞"),
    NOTE_ALREADY_COLLECTED(20010, "您已经收藏过该笔记"),
    NOTE_NOT_COLLECTED(20011, "您未收藏该篇笔记，无法取消收藏"),
    ;

    private final Integer code;
    private final String message;
}