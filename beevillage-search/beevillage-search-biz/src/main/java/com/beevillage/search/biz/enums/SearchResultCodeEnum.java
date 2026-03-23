package com.beevillage.search.biz.enums;

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
public enum SearchResultCodeEnum implements BaseExceptionInterface {

    SYSTEM_ERROR(10000, "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID(10001, "参数错误"),
    ;

    private final Integer code;
    private final String message;
}