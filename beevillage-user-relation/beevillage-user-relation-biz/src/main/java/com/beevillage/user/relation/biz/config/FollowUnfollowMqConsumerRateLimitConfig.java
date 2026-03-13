package com.beevillage.user.relation.biz.config;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 关注、取关消费者令牌桶配置类
 *
 * @author Jason Feng
 * @since 2026-03-11 22:34
 */
@Slf4j
@RefreshScope
@Configuration
public class FollowUnfollowMqConsumerRateLimitConfig {

    @Value("${mq-consumer.follow-unfollow.rate-limit}")
    private double rateLimit;

    @Bean
    @RefreshScope
    public RateLimiter rateLimiter() {
        log.info("关注/取关的限流速率为：{}", rateLimit);
        return RateLimiter.create(rateLimit);
    }
}