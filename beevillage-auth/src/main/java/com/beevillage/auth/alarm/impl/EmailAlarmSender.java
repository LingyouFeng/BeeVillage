package com.beevillage.auth.alarm.impl;

import com.beevillage.auth.alarm.AlarmSender;
import lombok.extern.slf4j.Slf4j;

/**
 * 通过邮件的方式发送告警信息
 *
 * @author Jason Feng
 * @since 2026-02-01 20:25
 */
@Slf4j
public class EmailAlarmSender implements AlarmSender {

    @Override
    public boolean send(String message) {
        // TODO: 发送邮件
        log.info("【发送邮件告警!】message：{}", message);
        return true;
    }
}
