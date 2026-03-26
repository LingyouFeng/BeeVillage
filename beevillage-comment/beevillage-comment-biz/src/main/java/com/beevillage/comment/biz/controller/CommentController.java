package com.beevillage.comment.biz.controller;

import com.beevillage.comment.biz.model.vo.PublishCommentReqVO;
import com.beevillage.comment.biz.service.CommentService;
import com.beevillage.common.response.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
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
    public Result<?> publishComment(@Validated @RequestBody PublishCommentReqVO publishCommentReqVO) {
        return commentService.publishComment(publishCommentReqVO);
    }
}
