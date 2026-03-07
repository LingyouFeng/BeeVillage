package com.beevillage.user.api.feign;

import com.beevillage.common.response.Result;
import com.beevillage.user.api.constant.ApiConstants;
import com.beevillage.user.api.dto.req.FindUserByIdReqDTO;
import com.beevillage.user.api.dto.req.FindUserByPhoneReqDTO;
import com.beevillage.user.api.dto.req.RegisterUserReqDTO;
import com.beevillage.user.api.dto.req.UpdateUserPasswordReqDTO;
import com.beevillage.user.api.dto.resp.FindUserByIdRspDTO;
import com.beevillage.user.api.dto.resp.FindUserByPhoneRspDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Jason Feng
 * @since 2026-02-27 15:57
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface UserFeignApi {

    String PREFIX = "/user";

    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/register")
    Result<Long> registerUser(@RequestBody RegisterUserReqDTO registerUserReqDTO);

    /**
     * 根据手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/findByPhone")
    Result<FindUserByPhoneRspDTO> findByPhone(@RequestBody FindUserByPhoneReqDTO findUserByPhoneReqDTO);

    /**
     * 更新密码
     *
     * @param updateUserPasswordReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/password/update")
    Result<?> updatePassword(@RequestBody UpdateUserPasswordReqDTO updateUserPasswordReqDTO);

    /**
     * 根据用户 ID 查询用户信息
     *
     * @param findUserByIdReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/findById")
    Result<FindUserByIdRspDTO> findById(@RequestBody FindUserByIdReqDTO findUserByIdReqDTO);
}