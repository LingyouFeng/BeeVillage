package com.beevillage.oss.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * OSS 服务业务类
 *
 * @since 2026-02-12 21:16
 * @author Jason Feng
 */
@Slf4j
@SpringBootApplication
public class BeeVillageOssBizApplication {

    public static void main(String[] args) {
        log.info("BeeVillageOssBiz 开始启动");
        SpringApplication.run(BeeVillageOssBizApplication.class, args);
        log.info("BeeVillageOssBiz 启动完成");
    }
}
