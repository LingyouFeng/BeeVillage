package com.beevillage.search.controller;

import com.beevillage.common.response.PageResult;
import com.beevillage.search.model.vo.SearchUserReqVO;
import com.beevillage.search.model.vo.SearchUserRspVO;
import com.beevillage.search.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户搜索服务
 *
 * @author Jason Feng
 * @since 2026-03-22 14:54
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user")
    public PageResult<SearchUserRspVO> searchUser(@RequestBody @Valid SearchUserReqVO searchUserReqVO) {
        return userService.searchUser(searchUserReqVO);
    }


}