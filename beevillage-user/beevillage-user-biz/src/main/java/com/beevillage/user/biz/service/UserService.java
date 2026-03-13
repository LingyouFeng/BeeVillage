package com.beevillage.user.biz.service;

import com.beevillage.common.response.Result;
import com.beevillage.user.api.dto.req.*;
import com.beevillage.user.api.dto.resp.FindUserByIdRspDTO;
import com.beevillage.user.api.dto.resp.FindUserByPhoneRspDTO;
import com.beevillage.user.biz.model.UpdateUserInfoReqVO;

import java.util.List;

/**
 *
 * @author Jason Feng
 * @since 2026-02-21 16:45
 */
public interface UserService {

    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO
     * @return
     */
    Result<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO);

    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    Result<Long> register(RegisterUserReqDTO registerUserReqDTO);

    /**
     * 根据手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO
     * @return
     */
    Result<FindUserByPhoneRspDTO> findByPhone(FindUserByPhoneReqDTO findUserByPhoneReqDTO);

    /**
     * 更新密码
     *
     * @param updateUserPasswordReqDTO
     * @return
     */
    Result<?> updatePassword(UpdateUserPasswordReqDTO updateUserPasswordReqDTO);

    /**
     * 根据用户 ID 查询用户信息
     *
     * @param findUserByIdReqDTO
     * @return
     */
    Result<FindUserByIdRspDTO> findById(FindUserByIdReqDTO findUserByIdReqDTO);

    /**
     * 批量根据用户 ID 查询用户信息
     *
     * @param findUsersByIdsReqDTO
     * @return
     */
    Result<List<FindUserByIdRspDTO>> findByIds(FindUsersByIdsReqDTO findUsersByIdsReqDTO);
}
