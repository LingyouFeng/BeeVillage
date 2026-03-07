package com.beevillage.note.biz.service;

import com.beevillage.common.response.Result;
import com.beevillage.note.biz.model.vo.FindNoteDetailReqVO;
import com.beevillage.note.biz.model.vo.FindNoteDetailRspVO;
import com.beevillage.note.biz.model.vo.PublishNoteReqVO;
import com.beevillage.note.biz.model.vo.UpdateNoteReqVO;

/**
 * 笔记业务
 *
 * @author Jason Feng
 * @since 2026-03-05 20:50
 */
public interface NoteService {

    /**
     * 笔记发布
     * @param publishNoteReqVO
     * @return
     */
    Result<?> publishNote(PublishNoteReqVO publishNoteReqVO);

    /**
     * 笔记详情
     * @param findNoteDetailReqVO
     * @return
     */
    Result<FindNoteDetailRspVO> findNoteDetail(FindNoteDetailReqVO findNoteDetailReqVO);


    /**
     * 笔记更新
     * @param updateNoteReqVO
     * @return
     */
    Result<?> updateNote(UpdateNoteReqVO updateNoteReqVO);
}
