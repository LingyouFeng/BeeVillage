package com.beevillage.common.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 时间工具类
 *
 * @author Jason Feng
 * @since 2026-03-10 15:08
 */
public class DateUtils {

    /**
     * LocalDateTime 转时间戳
     *
     * @param localDateTime
     * @return
     */
    public static long localDateTime2Timestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
