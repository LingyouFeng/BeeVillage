package com.beevillage.auth.service;

import com.beevillage.auth.model.UpdatePasswordReqVO;
import com.beevillage.auth.model.UserLoginReqVO;
import com.beevillage.common.response.Result;

/**
 *
 * @author Jason Feng
 * @since 2026-02-01 14:00
 */
public interface AuthService {

    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Result<?> loginAndRegister(UserLoginReqVO userLoginReqVO);

    /**
     * 登出
     * @return
     */
    Result<?> logout();

    /**
     * 修改密码
     * @param updatePasswordReqVO
     * @return
     */
    Result<?> updatePassword(UpdatePasswordReqVO updatePasswordReqVO);
}
