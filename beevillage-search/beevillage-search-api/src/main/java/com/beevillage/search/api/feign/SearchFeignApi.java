package com.beevillage.search.api.feign;

import com.beevillage.common.response.Result;
import com.beevillage.search.api.constant.ApiConstants;
import com.beevillage.search.api.dto.RebuildNoteDocumentReqDTO;
import com.beevillage.search.api.dto.RebuildUserDocumentReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Jason Feng
 * @since 2026-03-23 15:01
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface SearchFeignApi {

    String PREFIX = "/search";

    /**
     * 重建笔记文档
     * @param rebuildNoteDocumentReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/note/document/rebuild")
    Result<?> rebuildNoteDocument(@RequestBody RebuildNoteDocumentReqDTO rebuildNoteDocumentReqDTO);


    /**
     * 重建用户文档
     * @param rebuildUserDocumentReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/user/document/rebuild")
    Result<?> rebuildUserDocument(@RequestBody RebuildUserDocumentReqDTO rebuildUserDocumentReqDTO);

}