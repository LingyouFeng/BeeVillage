package com.beevillage.comment.biz.controller;

import com.beevillage.comment.biz.model.vo.FindCommentItemRspVO;
import com.beevillage.comment.biz.model.vo.FindCommentPageListReqVO;
import com.beevillage.comment.biz.model.vo.PublishCommentReqVO;
import com.beevillage.comment.biz.service.CommentService;
import com.beevillage.common.response.PageResult;
import com.beevillage.common.response.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论
 *
 * @author Jason Feng
 * @since 2026-03-23 20:38
 */
@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/publish")
    public Result<?> publishComment(@Valid @RequestBody PublishCommentReqVO publishCommentReqVO) {
        return commentService.publishComment(publishCommentReqVO);
    }

    @PostMapping("/list")
    public PageResult<FindCommentItemRspVO> findCommentPageList(@Valid @RequestBody FindCommentPageListReqVO findCommentPageListReqVO) {
        return commentService.findCommentPageList(findCommentPageListReqVO);
    }
}
