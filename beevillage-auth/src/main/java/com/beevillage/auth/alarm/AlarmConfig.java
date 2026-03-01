package com.beevillage.auth.alarm;

import com.beevillage.auth.alarm.impl.EmailAlarmSender;
import com.beevillage.auth.alarm.impl.SmsAlarmSender;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 告警信息发送方式配置类
 *
 * @author Jason Feng
 * @since 2026-02-01 20:23
 */
@Configuration
@RefreshScope
public class AlarmConfig {

    @Value("${alarm.type:sms}")
    private String alarmType;

    @Bean
    @RefreshScope
    public AlarmSender alarmHelper() {
        // 根据配置文件中的告警类型，初始化选择不同的告警实现类
        if (StringUtils.equals("sms", alarmType)) {
            return new SmsAlarmSender();
        } else if (StringUtils.equals("mail", alarmType)) {
            return new EmailAlarmSender();
        } else {
            throw new IllegalArgumentException("错误的告警类型...");
        }
    }
}