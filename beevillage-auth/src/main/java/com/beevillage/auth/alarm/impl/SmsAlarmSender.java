package com.beevillage.auth.alarm.impl;


import com.beevillage.auth.alarm.AlarmSender;
import lombok.extern.slf4j.Slf4j;

/**
 * 通过短信的方式发送告警信息
 *
 * @author Jason Feng
 * @since 2026-02-01 20:25
 */
@Slf4j
public class SmsAlarmSender implements AlarmSender {

    @Override
    public boolean send(String message) {
        // TODO: 发送短信
        log.info("【发送短信告警!】message：{}", message);
        return true;
    }
}
