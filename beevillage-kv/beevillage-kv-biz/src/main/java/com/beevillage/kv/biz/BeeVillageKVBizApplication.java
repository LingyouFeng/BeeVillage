package com.beevillage.kv.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Jason Feng
 * @since 2026-03-01 11:04
 */
@Slf4j
@SpringBootApplication
public class BeeVillageKVBizApplication {

    public static void main(String[] args) {
        log.info("BeeVillageKVBiz 开始启动");
        SpringApplication.run(BeeVillageKVBizApplication.class, args);
        log.info("BeeVillageKVBiz 启动完成");
    }

}
