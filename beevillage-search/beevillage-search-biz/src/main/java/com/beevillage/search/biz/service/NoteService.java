package com.beevillage.search.biz.service;

import com.beevillage.common.response.PageResult;
import com.beevillage.common.response.Result;
import com.beevillage.search.api.dto.RebuildNoteDocumentReqDTO;
import com.beevillage.search.biz.model.vo.SearchNoteReqVO;
import com.beevillage.search.biz.model.vo.SearchNoteRspVO;

/**
 * 笔记搜索业务
 *
 * @author Jason Feng
 * @since 2026-03-22 16:31
 */
public interface NoteService {

    /**
     * 搜索笔记
     * @param searchNoteReqVO
     * @return
     */
    PageResult<SearchNoteRspVO> searchNote(SearchNoteReqVO searchNoteReqVO);

    /**
     * 重建笔记文档
     * @param rebuildNoteDocumentReqDTO
     * @return
     */
    Result<Long> rebuildDocument(RebuildNoteDocumentReqDTO rebuildNoteDocumentReqDTO);
}
