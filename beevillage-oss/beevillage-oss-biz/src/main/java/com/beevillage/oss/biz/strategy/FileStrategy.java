package com.beevillage.oss.biz.strategy;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件策略接口
 *
 * @author Jason Feng
 * @since 2026-02-18 09:08
 */
public interface FileStrategy {

    /**
     * 文件上传
     *
     * @param file          上传文件
     * @param bucketName    桶名
     * @return              URI
     */
    String uploadFile(MultipartFile file, String bucketName);
}
