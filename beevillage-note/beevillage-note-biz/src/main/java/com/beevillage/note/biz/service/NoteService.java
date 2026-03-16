package com.beevillage.note.biz.service;

import com.beevillage.common.response.Result;
import com.beevillage.note.biz.model.vo.*;

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

    /**
     * 删除本地笔记缓存
     * @param noteId
     */
    void deleteNoteLocalCache(Long noteId);

    /**
     * 删除笔记
     * @param deleteNoteReqVO
     * @return
     */
    Result<?> deleteNote(DeleteNoteReqVO deleteNoteReqVO);

    /**
     * 笔记仅对自己可见
     * @param updateNoteVisibleOnlyMeReqVO
     * @return
     */
    Result<?> visibleOnlyMe(UpdateNoteVisibleOnlyMeReqVO updateNoteVisibleOnlyMeReqVO);

    /**
     * 笔记置顶 / 取消置顶
     * @param topNoteReqVO
     * @return
     */
    Result<?> topNote(TopNoteReqVO topNoteReqVO);

    /**
     * 点赞笔记
     * @param likeNoteReqVO
     * @return
     */
    Result<?> likeNote(LikeNoteReqVO likeNoteReqVO);

    /**
     * 取消点赞笔记
     * @param unlikeNoteReqVO
     * @return
     */
    Result<?> unlikeNote(UnlikeNoteReqVO unlikeNoteReqVO);

    /**
     * 收藏笔记
     * @param collectNoteReqVO
     * @return
     */
    Result<?> collectNote(CollectNoteReqVO collectNoteReqVO);

    /**
     * 取消收藏笔记
     * @param unCollectNoteReqVO
     * @return
     */
    Result<?> unCollectNote(UnCollectNoteReqVO unCollectNoteReqVO);
}
