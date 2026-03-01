package com.beevillage.oss.biz.service.impl;

import com.beevillage.common.response.Result;
import com.beevillage.oss.biz.service.FileService;
import com.beevillage.oss.biz.strategy.FileStrategy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jason Feng
 * @since 2026-02-18 09:37
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileStrategy fileStrategy;

    private static final String BUCKET_NAME = "beevillage";

    @Override
    public Result<?> uploadFile(MultipartFile file) {
        // 上传文件
        String url = fileStrategy.uploadFile(file, BUCKET_NAME);
        return Result.success(url);
    }
}
