package com.beevillage.user.relation.biz.rpc;

import cn.hutool.core.collection.CollUtil;
import com.beevillage.common.response.Result;
import com.beevillage.user.api.dto.req.FindUserByIdReqDTO;
import com.beevillage.user.api.dto.req.FindUsersByIdsReqDTO;
import com.beevillage.user.api.dto.resp.FindUserByIdRspDTO;
import com.beevillage.user.api.feign.UserFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 用户服务
 *
 * @author Jason Feng
 * @since 2026-03-06 11:47
 */
@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public FindUserByIdRspDTO findById(Long userId) {
        FindUserByIdReqDTO findUserByIdReqDTO = new FindUserByIdReqDTO();
        findUserByIdReqDTO.setId(userId);

        Result<FindUserByIdRspDTO> response = userFeignApi.findById(findUserByIdReqDTO);

        if (Objects.isNull(response) || !response.isSuccess()) {
            return null;
        }

        return response.getData();
    }


    /**
     * 批量查询用户信息
     *
     * @param userIds
     * @return
     */
    public List<FindUserByIdRspDTO> findByIds(List<Long> userIds) {
        FindUsersByIdsReqDTO findUsersByIdsReqDTO = new FindUsersByIdsReqDTO();
        findUsersByIdsReqDTO.setIds(userIds);

        Result<List<FindUserByIdRspDTO>> response = userFeignApi.findByIds(findUsersByIdsReqDTO);

        if (!response.isSuccess() || Objects.isNull(response.getData()) || CollUtil.isEmpty(response.getData())) {
            return null;
        }

        return response.getData();
    }
}
