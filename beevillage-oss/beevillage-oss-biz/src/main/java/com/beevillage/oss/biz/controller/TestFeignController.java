package com.beevillage.oss.biz.controller;

import com.beevillage.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jason Feng
 * @since 2026-02-24 20:59
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class TestFeignController {

    @PostMapping(value = "/test")
    public Result<?> test() {
        log.info("=============> test");
        return Result.success();
    }

}