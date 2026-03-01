package com.beevillage.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *
 * @author Jason Feng
 * @since 2026-01-31 19:50
 */
@Slf4j
@SpringBootTest
public class RedisTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set key value
     */
    @Test
    void testSetKeyValue() {
        redisTemplate.delete("name");
    }
}
