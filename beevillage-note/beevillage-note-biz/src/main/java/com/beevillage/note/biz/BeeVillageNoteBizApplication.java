package com.beevillage.note.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 笔记服务启动类
 *
 * @since 2026-01-31 16:14
 * @author Jason Feng
 */
@Slf4j
@SpringBootApplication
@EnableFeignClients(basePackages = "com.beevillage")
public class BeeVillageNoteBizApplication {

    public static void main(String[] args) {
        log.info("BeeVillageNoteBiz开始启动！");
        SpringApplication.run(BeeVillageNoteBizApplication.class, args);
        log.info("BeeVillageNoteBiz启动完成！");
    }
}
