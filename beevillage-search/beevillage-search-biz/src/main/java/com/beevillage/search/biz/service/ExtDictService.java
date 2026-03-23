package com.beevillage.search.biz.service;

import org.springframework.http.ResponseEntity;

/**
 * 拓展词典
 *
 * @author Jason Feng
 * @since 2026-03-22 17:49
 */
public interface ExtDictService {

    /**
     * 获取热更新词典
     * @return
     */
    ResponseEntity<String> getHotUpdateExtDict();
}
