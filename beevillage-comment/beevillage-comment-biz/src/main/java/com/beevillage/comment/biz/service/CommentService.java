package com.beevillage.comment.biz.service;

import com.beevillage.comment.biz.model.vo.FindCommentItemRspVO;
import com.beevillage.comment.biz.model.vo.FindCommentPageListReqVO;
import com.beevillage.comment.biz.model.vo.PublishCommentReqVO;
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
}
