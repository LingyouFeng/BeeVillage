package com.beevillage.data.align.rpc;

import com.beevillage.common.response.Result;
import com.beevillage.search.api.dto.RebuildNoteDocumentReqDTO;
import com.beevillage.search.api.dto.RebuildUserDocumentReqDTO;
import com.beevillage.search.api.feign.SearchFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 搜索服务
 *
 * @author Jason Feng
 * @since 2026-03-23 15:06
 */
@Component
public class SearchRpcService {

    @Resource
    private SearchFeignApi searchFeignApi;

    /**
     * 调用重建笔记文档接口
     * @param noteId
     */
    public Result<?> rebuildNoteDocument(Long noteId) {
        RebuildNoteDocumentReqDTO rebuildNoteDocumentReqDTO = RebuildNoteDocumentReqDTO.builder()
                .id(noteId)
                .build();

        return searchFeignApi.rebuildNoteDocument(rebuildNoteDocumentReqDTO);
    }

    /**
     * 调用重建用户文档接口
     * @param userId
     */
    public Result<?> rebuildUserDocument(Long userId) {
        RebuildUserDocumentReqDTO rebuildUserDocumentReqDTO = RebuildUserDocumentReqDTO.builder()
                .id(userId)
                .build();

        return searchFeignApi.rebuildUserDocument(rebuildUserDocumentReqDTO);
    }
}