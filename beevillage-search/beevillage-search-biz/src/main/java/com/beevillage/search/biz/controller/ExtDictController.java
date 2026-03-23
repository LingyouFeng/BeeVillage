package com.beevillage.search.biz.controller;

import com.beevillage.search.biz.service.ExtDictService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热更新拓展词典
 *
 * @author Jason Feng
 * @since 2026-03-22 17:54
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class ExtDictController {

    @Resource
    private ExtDictService extDictService;

    @GetMapping("/ext/dict")
    public ResponseEntity<String> extDict() {
        return extDictService.getHotUpdateExtDict();
    }

}