package com.beevillage.oss.biz.enums;

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
public enum OssResultCodeEnum implements BaseExceptionInterface {

    FILE_SIZE_LIMIT(1, "文件大小过大");

    private final Integer code;
    private final String message;
}