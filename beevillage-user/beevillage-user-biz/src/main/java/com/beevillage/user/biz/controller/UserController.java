package com.beevillage.user.biz.controller;

import com.beevillage.common.response.Result;
import com.beevillage.user.api.dto.req.FindUserByIdReqDTO;
import com.beevillage.user.api.dto.req.FindUserByPhoneReqDTO;
import com.beevillage.user.api.dto.req.RegisterUserReqDTO;
import com.beevillage.user.api.dto.req.UpdateUserPasswordReqDTO;
import com.beevillage.user.api.dto.resp.FindUserByIdRspDTO;
import com.beevillage.user.api.dto.resp.FindUserByPhoneRspDTO;
import com.beevillage.user.biz.model.UpdateUserInfoReqVO;
import com.beevillage.user.biz.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jason Feng
 * @since 2026-02-01 14:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户信息修改
     *
     * @param updateUserInfoReqVO   更新的用户信息数据
     * @return                      响应结果
     */
    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<?> updateUserInfo(@Valid UpdateUserInfoReqVO updateUserInfoReqVO) {
        return userService.updateUserInfo(updateUserInfoReqVO);
    }

    // ===================================== 对其他服务提供的接口 =====================================
    /**
     * 新用户注册
     *
     * @param registerUserReqDTO    注册的用户信息数据
     * @return                      响应结果
     */
    @PostMapping("/register")
    public Result<Long> register(@Valid @RequestBody RegisterUserReqDTO registerUserReqDTO) {
        return userService.register(registerUserReqDTO);
    }

    /**
     * 手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO 查询的用户信息数据
     * @return                      响应结果
     */
    @PostMapping("/findByPhone")
    public Result<FindUserByPhoneRspDTO> findByPhone(@Valid @RequestBody FindUserByPhoneReqDTO findUserByPhoneReqDTO) {
        return userService.findByPhone(findUserByPhoneReqDTO);
    }

    /**
     * 密码更新
     *
     * @param updateUserPasswordReqDTO  加密后的密码
     * @return                          响应结果
     */
    @PostMapping("/password/update")
    public Result<?> updatePassword(@Valid @RequestBody UpdateUserPasswordReqDTO updateUserPasswordReqDTO) {
        return userService.updatePassword(updateUserPasswordReqDTO);
    }

    /**
     * 密码更新
     *
     * @param findUserByIdReqDTO    用户 id
     * @return                      响应结果
     */
    @PostMapping("/findById")
    public Result<FindUserByIdRspDTO> findById(@Valid @RequestBody FindUserByIdReqDTO findUserByIdReqDTO) {
        return userService.findById(findUserByIdReqDTO);
    }
}
