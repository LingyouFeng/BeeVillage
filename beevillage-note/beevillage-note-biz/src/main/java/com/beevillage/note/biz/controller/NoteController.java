package com.beevillage.note.biz.controller;

import com.beevillage.common.response.Result;
import com.beevillage.note.biz.model.vo.FindNoteDetailReqVO;
import com.beevillage.note.biz.model.vo.FindNoteDetailRspVO;
import com.beevillage.note.biz.model.vo.PublishNoteReqVO;
import com.beevillage.note.biz.model.vo.UpdateNoteReqVO;
import com.beevillage.note.biz.service.NoteService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 笔记
 *
 * @author Jason Feng
 * @since 2026-03-05 20:59
 */
@RestController
@RequestMapping("/note")
@Slf4j
public class NoteController {

    @Resource
    private NoteService noteService;

    @PostMapping(value = "/publish")
    public Result<?> publishNote(@Valid @RequestBody PublishNoteReqVO publishNoteReqVO) {
        return noteService.publishNote(publishNoteReqVO);
    }

    @PostMapping(value = "/detail")
    public Result<FindNoteDetailRspVO> findNoteDetail(@Valid @RequestBody FindNoteDetailReqVO findNoteDetailReqVO) {
        return noteService.findNoteDetail(findNoteDetailReqVO);
    }

    @PostMapping(value = "/update")
    public Result<?> updateNote(@Valid @RequestBody UpdateNoteReqVO updateNoteReqVO) {
        return noteService.updateNote(updateNoteReqVO);
    }

}