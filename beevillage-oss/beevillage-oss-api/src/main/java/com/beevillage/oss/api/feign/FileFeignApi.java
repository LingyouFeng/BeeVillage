package com.beevillage.oss.api.feign;

import com.beevillage.common.response.Result;
import com.beevillage.oss.api.config.FeignFormConfig;
import com.beevillage.oss.api.constant.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jason Feng
 * @since 2026-02-24 21:01
 */
@FeignClient(name = ApiConstants.SERVICE_NAME, configuration = FeignFormConfig.class)
public interface FileFeignApi {

    String PREFIX = "/file";

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping(value = PREFIX + "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<?> uploadFile(@RequestPart(value = "file") MultipartFile file);

}