package com.beevillage.search.biz.controller;

import com.beevillage.common.response.PageResult;
import com.beevillage.common.response.Result;
import com.beevillage.search.api.dto.RebuildNoteDocumentReqDTO;
import com.beevillage.search.biz.model.vo.SearchNoteReqVO;
import com.beevillage.search.biz.model.vo.SearchNoteRspVO;
import com.beevillage.search.biz.service.NoteService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 笔记搜索
 *
 * @author Jason Feng
 * @since 2026-03-22 16:36
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class NoteController {

    @Resource
    private NoteService noteService;

    @PostMapping("/note")
    public PageResult<SearchNoteRspVO> searchNote(@RequestBody @Valid SearchNoteReqVO searchNoteReqVO) {
        return noteService.searchNote(searchNoteReqVO);
    }

    // ===================================== 对其他服务提供的接口 =====================================
    @PostMapping("/note/document/rebuild")
    public Result<Long> rebuildDocument(@Valid @RequestBody RebuildNoteDocumentReqDTO rebuildNoteDocumentReqDTO) {
        return noteService.rebuildDocument(rebuildNoteDocumentReqDTO);
    }
}