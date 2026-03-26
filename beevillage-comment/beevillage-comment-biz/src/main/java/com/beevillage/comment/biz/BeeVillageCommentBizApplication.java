package com.beevillage.comment.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

/**
 * 评论服务启动类
 *
 * @since 2026-03-23 17:35
 * @author Jason Feng
 */
@Slf4j
@EnableRetry
@SpringBootApplication
@EnableFeignClients(basePackages = "com.beevillage")
public class BeeVillageCommentBizApplication {

    public static void main( String[] args ) {
        log.info("BeeVillageCommentBiz开始启动！");
        SpringApplication.run(BeeVillageCommentBizApplication.class, args);
        log.info("BeeVillageCommentBiz启动完成！");
    }
}
