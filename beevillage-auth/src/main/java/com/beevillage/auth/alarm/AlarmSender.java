package com.beevillage.auth.alarm;

/**
 * 发送告警信息
 *
 * @author Jason Feng
 * @since 2026-02-01 20:25
 */
public interface AlarmSender {

    /**
     * 发送告警信息
     *
     * @param message   告警信息
     * @return          告警信息是否发送成功
     */
    boolean send(String message);
}
