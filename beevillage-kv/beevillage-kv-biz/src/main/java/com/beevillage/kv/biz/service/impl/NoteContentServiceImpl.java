package com.beevillage.kv.biz.service.impl;

import com.beevillage.common.exception.BusinessException;
import com.beevillage.common.response.Result;
import com.beevillage.kv.api.dto.req.AddNoteContentReqDTO;
import com.beevillage.kv.api.dto.req.DeleteNoteContentReqDTO;
import com.beevillage.kv.api.dto.req.FindNoteContentReqDTO;
import com.beevillage.kv.api.dto.rsp.FindNoteContentRspDTO;
import com.beevillage.kv.biz.domain.dataobject.NoteContentDO;
import com.beevillage.kv.biz.domain.repository.NoteContentRepository;
import com.beevillage.kv.biz.enums.KvResultCodeEnum;
import com.beevillage.kv.biz.service.NoteContentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author Jason Feng
 * @since 2026-03-01 13:25
 */
@Slf4j
@Service
public class NoteContentServiceImpl implements NoteContentService {

    @Resource
    private NoteContentRepository noteContentRepository;


    @Override
    public Result<?> addNoteContent(AddNoteContentReqDTO addNoteContentReqDTO) {
        // 笔记 ID
        String uuid = addNoteContentReqDTO.getUuid();
        // 笔记内容
        String content = addNoteContentReqDTO.getContent();

        // 构建数据库 DO 实体类
        // TODO: 暂时用 UUID, 目的是为了下一章讲解压测，不用动态传笔记 ID。后续改为笔记服务传过来的笔记 ID
        NoteContentDO nodeContent = NoteContentDO.builder()
                .id(UUID.fromString(uuid))
                .content(content)
                .build();

        // 插入数据
        noteContentRepository.save(nodeContent);

        return Result.success();
    }

    @Override
    public Result<FindNoteContentRspDTO> findNoteContent(FindNoteContentReqDTO findNoteContentReqDTO) {
        // 笔记 UUID
        String uuid = findNoteContentReqDTO.getUuid();
        // 根据笔记 UUID 查询笔记内容
        Optional<NoteContentDO> optional = noteContentRepository.findById(UUID.fromString(uuid));

        // 若笔记内容不存在
        if (optional.isEmpty()) {
            throw new BusinessException(KvResultCodeEnum.NOTE_CONTENT_NOT_FOUND);
        }

        NoteContentDO noteContentDO = optional.get();
        // 构建返参 DTO
        FindNoteContentRspDTO findNoteContentRspDTO = FindNoteContentRspDTO.builder()
                .uuid(noteContentDO.getId())
                .content(noteContentDO.getContent())
                .build();

        return Result.success(findNoteContentRspDTO);
    }

    @Override
    public Result<?> deleteNoteContent(DeleteNoteContentReqDTO deleteNoteContentReqDTO) {
        // 笔记 UUID
        String uuid = deleteNoteContentReqDTO.getUuid();
        // 删除笔记内容
        noteContentRepository.deleteById(UUID.fromString(uuid));

        return Result.success();
    }
}
