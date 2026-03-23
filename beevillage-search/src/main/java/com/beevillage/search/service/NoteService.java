package com.beevillage.search.service;

import com.beevillage.common.response.PageResult;
import com.beevillage.search.model.vo.SearchNoteReqVO;
import com.beevillage.search.model.vo.SearchNoteRspVO;

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
}
