package com.beevillage.search.biz.service;

import com.beevillage.common.response.PageResult;
import com.beevillage.common.response.Result;
import com.beevillage.search.api.dto.RebuildUserDocumentReqDTO;
import com.beevillage.search.biz.model.vo.SearchUserReqVO;
import com.beevillage.search.biz.model.vo.SearchUserRspVO;

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

    /**
     * 重建用户文档
     * @param rebuildUserDocumentReqDTO
     * @return
     */
    Result<Long> rebuildDocument(RebuildUserDocumentReqDTO rebuildUserDocumentReqDTO);
}
