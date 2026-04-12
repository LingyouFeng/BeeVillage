package com.beevillage.kv.biz.controller;

import com.beevillage.common.response.Result;
import com.beevillage.kv.api.dto.req.BatchAddCommentContentReqDTO;
import com.beevillage.kv.api.dto.req.BatchFindCommentContentReqDTO;
import com.beevillage.kv.api.dto.req.DeleteCommentContentReqDTO;
import com.beevillage.kv.biz.service.CommentContentService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论内容
 *
 * @author Jason Feng
 * @since 2026-03-23 21:45
 */
@RestController
@RequestMapping("/kv")
@Slf4j
public class CommentContentController {

    @Resource
    private CommentContentService commentContentService;

    @PostMapping(value = "/comment/content/batchAdd")
    public Result<?> batchAddCommentContent(@Valid @RequestBody BatchAddCommentContentReqDTO batchAddCommentContentReqDTO) {
        return commentContentService.batchAddCommentContent(batchAddCommentContentReqDTO);
    }

    @PostMapping(value = "/comment/content/batchFind")
    public Result<?> batchFindCommentContent(@Valid @RequestBody BatchFindCommentContentReqDTO batchFindCommentContentReqDTO) {
        return commentContentService.batchFindCommentContent(batchFindCommentContentReqDTO);
    }

    @PostMapping(value = "/comment/content/delete")
    public Result<?> deleteCommentContent(@Validated @RequestBody DeleteCommentContentReqDTO deleteCommentContentReqDTO) {
        return commentContentService.deleteCommentContent(deleteCommentContentReqDTO);
    }
}
