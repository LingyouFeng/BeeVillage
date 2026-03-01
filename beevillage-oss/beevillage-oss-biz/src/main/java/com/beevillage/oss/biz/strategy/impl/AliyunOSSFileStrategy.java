package com.beevillage.oss.biz.strategy.impl;

import com.beevillage.oss.biz.strategy.FileStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

/**
 * 阿里云OSS 文件上传
 *
 * @author Jason Feng
 * @since 2026-02-18 09:11
 */
@Slf4j
public class AliyunOSSFileStrategy implements FileStrategy {

    @Override
    public String uploadFile(MultipartFile file, String bucketName) {
        log.info("## 上传文件至阿里云 OSS ...");
        return "";
    }
}
