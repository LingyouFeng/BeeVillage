package com.beevillage.kv.biz.service;

import com.beevillage.common.response.Result;
import com.beevillage.kv.api.dto.req.BatchAddCommentContentReqDTO;

/**
 * 评论内容存储业务
 *
 * @author Jason Feng
 * @since 2026-03-23 21:23
 */
public interface CommentContentService {

    /**
     * 批量添加评论内容
     * @param batchAddCommentContentReqDTO
     * @return
     */
    Result<?> batchAddCommentContent(BatchAddCommentContentReqDTO batchAddCommentContentReqDTO);
}
