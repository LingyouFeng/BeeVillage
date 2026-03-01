package com.beevillage.oss.biz.service;

import com.beevillage.common.response.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jason Feng
 * @since 2026-02-18 09:35
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    Result<?> uploadFile(MultipartFile file);
}