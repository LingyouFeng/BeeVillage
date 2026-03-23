package com.beevillage.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 搜索服务启动类
 *
 * @since 2026-03-22 14:38
 * @author Jason Feng
 */
@Slf4j
@SpringBootApplication
// @EnableFeignClients(basePackages = "com.beevillage")
public class BeeVillageSearchApplication {

    public static void main(String[] args) {
        log.info("BeeVillageSearch开始启动！");
        SpringApplication.run(BeeVillageSearchApplication.class, args);
        log.info("BeeVillageSearch启动完成！");
    }
}
