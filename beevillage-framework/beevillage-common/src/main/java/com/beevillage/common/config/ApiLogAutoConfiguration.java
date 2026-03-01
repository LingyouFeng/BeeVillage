package com.beevillage.common.config;

import com.beevillage.common.aspect.ApiLogAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Jason Feng
 * @since 2026-02-07 20:02
 */
@AutoConfiguration
public class ApiLogAutoConfiguration {

    @Bean
    public ApiLogAspect apiLogAspect() {
        return new ApiLogAspect();
    }
}
