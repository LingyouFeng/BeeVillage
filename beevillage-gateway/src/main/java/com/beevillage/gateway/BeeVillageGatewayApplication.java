package com.beevillage.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网关服务类
 *
 * @since 2026-02-03 21:18
 * @author Jason Feng
 */
@Slf4j
@SpringBootApplication
public class BeeVillageGatewayApplication  {

    public static void main( String[] args ) {
        log.info("BeeVillageGateway 开始启动");
        SpringApplication.run(BeeVillageGatewayApplication.class, args);
        log.info("BeeVillageGateway 启动完成");
    }
}
