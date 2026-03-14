package com.beevillage.count.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 计数服务启动类
 *
 * @author Jason Feng
 * @since 2026-03-13 16:33
 */
@Slf4j
@SpringBootApplication
// @EnableFeignClients(basePackages = "com.beevillage")
public class BeeVillageCountBizApplication {

    public static void main( String[] args ) {
        log.info("BeeVillageCountBiz开始启动！");
        SpringApplication.run(BeeVillageCountBizApplication.class, args);
        log.info("BeeVillageCountBiz启动完成！");
    }
}
