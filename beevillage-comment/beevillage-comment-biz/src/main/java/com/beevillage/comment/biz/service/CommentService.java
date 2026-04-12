package com.beevillage.comment.biz.service;

import com.beevillage.comment.biz.model.vo.*;
import com.beevillage.common.response.PageResult;
import com.beevillage.common.response.Result;

/**
 * 评论业务
 *
 * @author Jason Feng
 * @since 2026-03-23 20:29
 */
public interface CommentService {

    /**
     * 发布评论
     * @param publishCommentReqVO
     * @return
     */
    Result<?> publishComment(PublishCommentReqVO publishCommentReqVO);

    /**
     * 评论列表分页查询
     * @param findCommentPageListReqVO
     * @return
     */
    PageResult<FindCommentItemRspVO> findCommentPageList(FindCommentPageListReqVO findCommentPageListReqVO);

    /**
     * 二级评论分页查询
     * @param findChildCommentPageListReqVO
     * @return
     */
    PageResult<FindChildCommentItemRspVO> findChildCommentPageList(FindChildCommentPageListReqVO findChildCommentPageListReqVO);

    /**
     * 评论点赞
     * @param likeCommentReqVO
     * @return
     */
    Result<?> likeComment(LikeCommentReqVO likeCommentReqVO);

    /**
     * 取消评论点赞
     * @param unLikeCommentReqVO
     * @return
     */
    Result<?> unlikeComment(UnLikeCommentReqVO unLikeCommentReqVO);

    /**
     * 删除评论
     * @param deleteCommentReqVO
     * @return
     */
    Result<?> deleteComment(DeleteCommentReqVO deleteCommentReqVO);

    /**
     * 删除本地评论缓存
     * @param commentId
     */
    void deleteCommentLocalCache(Long commentId);
}
