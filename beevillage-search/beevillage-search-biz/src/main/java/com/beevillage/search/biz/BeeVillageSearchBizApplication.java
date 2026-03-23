package com.beevillage.search.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 搜索服务启动类
 *
 * @since 2026-03-22 14:38
 * @author Jason Feng
 */
@Slf4j
@SpringBootApplication
@EnableScheduling
public class BeeVillageSearchBizApplication {

    public static void main(String[] args) {
        log.info("BeeVillageSearchBiz开始启动！");
        SpringApplication.run(BeeVillageSearchBizApplication.class, args);
        log.info("BeeVillageSearchBiz启动完成！");
    }
}
