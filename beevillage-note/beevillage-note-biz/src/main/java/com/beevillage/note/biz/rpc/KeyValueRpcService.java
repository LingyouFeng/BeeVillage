package com.beevillage.note.biz.rpc;

import com.beevillage.common.response.Result;
import com.beevillage.kv.api.dto.req.AddNoteContentReqDTO;
import com.beevillage.kv.api.dto.req.DeleteNoteContentReqDTO;
import com.beevillage.kv.api.dto.req.FindNoteContentReqDTO;
import com.beevillage.kv.api.dto.rsp.FindNoteContentRspDTO;
import com.beevillage.kv.api.feign.KeyValueFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 *
 * @author Jason Feng
 * @since 2026-03-05 20:44
 */
@Component
public class KeyValueRpcService {

    @Resource
    private KeyValueFeignApi keyValueFeignApi;

    /**
     * 保存笔记内容
     *
     * @param uuid
     * @param content
     * @return
     */
    public boolean saveNoteContent(String uuid, String content) {
        AddNoteContentReqDTO addNoteContentReqDTO = new AddNoteContentReqDTO();
        addNoteContentReqDTO.setUuid(uuid);
        addNoteContentReqDTO.setContent(content);

        Result<?> response = keyValueFeignApi.addNoteContent(addNoteContentReqDTO);

        return Objects.nonNull(response) && response.isSuccess();
    }

    /**
     * 删除笔记内容
     *
     * @param uuid
     * @return
     */
    public boolean deleteNoteContent(String uuid) {
        DeleteNoteContentReqDTO deleteNoteContentReqDTO = new DeleteNoteContentReqDTO();
        deleteNoteContentReqDTO.setUuid(uuid);

        Result<?> response = keyValueFeignApi.deleteNoteContent(deleteNoteContentReqDTO);

        return Objects.nonNull(response) && response.isSuccess();
    }

    /**
     * 查询笔记内容
     *
     * @param uuid
     * @return
     */
    public String findNoteContent(String uuid) {
        FindNoteContentReqDTO findNoteContentReqDTO = new FindNoteContentReqDTO();
        findNoteContentReqDTO.setUuid(uuid);

        Result<FindNoteContentRspDTO> response = keyValueFeignApi.findNoteContent(findNoteContentReqDTO);

        if (Objects.isNull(response) || !response.isSuccess() || Objects.isNull(response.getData())) {
            return null;
        }

        return response.getData().getContent();
    }

}
