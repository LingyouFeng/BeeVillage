package com.beevillage.kv.biz.controller;

import com.beevillage.common.response.Result;
import com.beevillage.kv.api.dto.req.AddNoteContentReqDTO;
import com.beevillage.kv.api.dto.req.DeleteNoteContentReqDTO;
import com.beevillage.kv.api.dto.req.FindNoteContentReqDTO;
import com.beevillage.kv.api.dto.rsp.FindNoteContentRspDTO;
import com.beevillage.kv.biz.service.NoteContentService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 笔记内容
 *
 * @author Jason Feng
 * @since 2026-03-01 13:27
 */
@Slf4j
@RestController
@RequestMapping("/kv")
public class NoteContentController {

    @Resource
    private NoteContentService noteContentService;

    @PostMapping(value = "/note/content/add")
    public Result<?> addNoteContent(@Valid @RequestBody AddNoteContentReqDTO addNoteContentReqDTO) {
        return noteContentService.addNoteContent(addNoteContentReqDTO);
    }

    @PostMapping(value = "/note/content/find")
    public Result<FindNoteContentRspDTO> findNoteContent(@Valid @RequestBody FindNoteContentReqDTO findNoteContentReqDTO) {
        return noteContentService.findNoteContent(findNoteContentReqDTO);
    }

    @PostMapping(value = "/note/content/delete")
    public Result<?> deleteNoteContent(@Valid @RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO) {
        return noteContentService.deleteNoteContent(deleteNoteContentReqDTO);
    }
}