package com.beevillage.search.service;

import com.beevillage.common.response.PageResult;
import com.beevillage.search.model.vo.SearchUserReqVO;
import com.beevillage.search.model.vo.SearchUserRspVO;

/**
 * 用户搜索业务
 *
 * @author Jason Feng
 * @since 2026-03-22 14:47
 */
public interface UserService {

    /**
     * 搜索用户
     * @param searchUserReqVO
     * @return
     */
    PageResult<SearchUserRspVO> searchUser(SearchUserReqVO searchUserReqVO);
}
