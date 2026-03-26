package com.beevillage.kv.biz.service.impl;

import com.beevillage.common.response.Result;
import com.beevillage.kv.api.dto.req.BatchAddCommentContentReqDTO;
import com.beevillage.kv.api.dto.req.CommentContentReqDTO;
import com.beevillage.kv.biz.domain.dataobject.CommentContentDO;
import com.beevillage.kv.biz.domain.dataobject.CommentContentPrimaryKey;
import com.beevillage.kv.biz.service.CommentContentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 评论内容业务
 *
 * @author Jason Feng
 * @since 2026-03-23 21:24
 */
@Slf4j
@Service
public class CommentContentServiceImpl implements CommentContentService {

    @Resource
    private CassandraTemplate cassandraTemplate;

    /**
     * 批量添加评论内容
     *
     * @param batchAddCommentContentReqDTO
     * @return
     */
    @Override
    public Result<?> batchAddCommentContent(BatchAddCommentContentReqDTO batchAddCommentContentReqDTO) {
        List<CommentContentReqDTO> comments = batchAddCommentContentReqDTO.getComments();

        // DTO 转 DO
        List<CommentContentDO> contentDOS = comments.stream()
                .map(commentContentReqDTO -> {
                    // 构建主键类
                    CommentContentPrimaryKey commentContentPrimaryKey = CommentContentPrimaryKey.builder()
                            .noteId(commentContentReqDTO.getNoteId())
                            .yearMonth(commentContentReqDTO.getYearMonth())
                            .contentId(UUID.fromString(commentContentReqDTO.getContentId()))
                            .build();

                    // DO 实体类
                    return CommentContentDO.builder()
                            .primaryKey(commentContentPrimaryKey)
                            .content(commentContentReqDTO.getContent())
                            .build();
                }).toList();

        // 批量插入
        cassandraTemplate.batchOps()
                .insert(contentDOS)
                .execute();

        return Result.success();
    }
}
