package com.beevillage.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户登录、认证模块启动类
 *
 * @since 2026-01-31 16:14
 * @author Jason Feng
 */
@Slf4j
@SpringBootApplication
@EnableFeignClients(basePackages = "com.beevillage")
public class BeeVillageAuthApplication {

    public static void main(String[] args) {
        log.info("BeeVillage-Auth开始启动！");
        SpringApplication.run(BeeVillageAuthApplication.class, args);
        log.info("BeeVillage-Auth启动完成！");
    }

}
