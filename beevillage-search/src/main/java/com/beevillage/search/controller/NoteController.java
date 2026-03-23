package com.beevillage.search.controller;

import com.beevillage.common.response.PageResult;
import com.beevillage.search.model.vo.SearchNoteReqVO;
import com.beevillage.search.model.vo.SearchNoteRspVO;
import com.beevillage.search.service.NoteService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
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
    public PageResult<SearchNoteRspVO> searchNote(@RequestBody @Validated SearchNoteReqVO searchNoteReqVO) {
        return noteService.searchNote(searchNoteReqVO);
    }

}