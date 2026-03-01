package com.beevillage.leaf.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Jason Feng
 * @since 2026-03-01 20:10
 */
@Slf4j
@SpringBootApplication
public class BeeVillageLeafBizApplication {

    public static void main( String[] args ) {
        log.info("BeeVillageLeafBiz 开始启动");
        SpringApplication.run(BeeVillageLeafBizApplication.class, args);
        log.info("BeeVillageLeafBiz 启动完成");
    }
}
