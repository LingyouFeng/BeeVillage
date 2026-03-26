package com.beevillage.comment.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.beevillage.comment.biz.constant.MQConstants;
import com.beevillage.comment.biz.model.dto.PublishCommentMqDTO;
import com.beevillage.comment.biz.model.vo.PublishCommentReqVO;
import com.beevillage.comment.biz.retry.SendMqRetryHelper;
import com.beevillage.comment.biz.rpc.LeafRpcService;
import com.beevillage.comment.biz.service.CommentService;
import com.beevillage.common.response.Result;
import com.beevillage.context.holder.LoginUserContextHolder;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 *
 * @author Jason Feng
 * @since 2026-03-23 20:29
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private SendMqRetryHelper sendMqRetryHelper;
    @Resource
    private LeafRpcService leafRpcService;

    /**
     * 发布评论
     *
     * @param publishCommentReqVO
     * @return
     */
    @Override
    public Result<?> publishComment(PublishCommentReqVO publishCommentReqVO) {
        // 评论正文
        String content = publishCommentReqVO.getContent();
        // 附近图片
        String imageUrl = publishCommentReqVO.getImageUrl();

        // 评论内容和图片不能同时为空
        Preconditions.checkArgument(StringUtils.isNotBlank(content) || StringUtils.isNotBlank(imageUrl),
                "评论正文和图片不能同时为空");

        // 发布者 ID
        Long creatorId = LoginUserContextHolder.getUserId();

        // RPC: 调用分布式 ID 生成服务，生成评论 ID
        String commentId = leafRpcService.generateCommentId();

        // 发送 MQ
        // 构建消息体 DTO
        PublishCommentMqDTO publishCommentMqDTO = PublishCommentMqDTO.builder()
                .noteId(publishCommentReqVO.getNoteId())
                .commentId(Long.valueOf(commentId))
                .content(content)
                .imageUrl(imageUrl)
                .replyCommentId(publishCommentReqVO.getReplyCommentId())
                .createTime(LocalDateTime.now())
                .creatorId(creatorId)
                .build();

        // 发送 MQ (包含重试机制)
        sendMqRetryHelper.asyncSend(MQConstants.TOPIC_PUBLISH_COMMENT, JSON.toJSONString(publishCommentMqDTO));

        return Result.success();
    }
}
