package com.beevillage.kv.api.feign;

import com.beevillage.common.response.Result;
import com.beevillage.kv.api.constant.ApiConstants;
import com.beevillage.kv.api.dto.req.AddNoteContentReqDTO;
import com.beevillage.kv.api.dto.req.BatchAddCommentContentReqDTO;
import com.beevillage.kv.api.dto.req.DeleteNoteContentReqDTO;
import com.beevillage.kv.api.dto.req.FindNoteContentReqDTO;
import com.beevillage.kv.api.dto.rsp.FindNoteContentRspDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * K-V 键值存储 Feign 接口
 *
 * @author Jason Feng
 * @since 2026-03-01 13:44
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface KeyValueFeignApi {

    String PREFIX = "/kv";

    @PostMapping(value = PREFIX + "/note/content/add")
    Result<?> addNoteContent(@RequestBody AddNoteContentReqDTO addNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/note/content/find")
    Result<FindNoteContentRspDTO> findNoteContent(@RequestBody FindNoteContentReqDTO findNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/note/content/delete")
    Result<?> deleteNoteContent(@RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/comment/content/batchAdd")
    Result<?> batchAddCommentContent(@RequestBody BatchAddCommentContentReqDTO batchAddCommentContentReqDTO);
}
