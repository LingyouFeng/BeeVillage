package com.beevillage.user.relation.biz.config;

import org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Jason Feng
 * @since 2026-03-11 19:39
 */
@Configuration
@Import(RocketMQAutoConfiguration.class)
public class RocketMQConfig {
}
