package com.beevillage.user.relation.biz.controller;

import com.beevillage.common.response.PageResult;
import com.beevillage.common.response.Result;
import com.beevillage.user.relation.biz.model.vo.*;
import com.beevillage.user.relation.biz.service.RelationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户关系
 *
 * @author Jason Feng
 * @since 2026-03-10 10:58
 */
@Slf4j
@RestController
@RequestMapping("/relation")
public class RelationController {

    @Resource
    private RelationService relationService;

    @PostMapping("/follow")
    public Result<?> follow(@Valid @RequestBody FollowUserReqVO followUserReqVO) {
        return relationService.follow(followUserReqVO);
    }

    @PostMapping("/unfollow")
    public Result<?> unfollow(@Valid @RequestBody UnfollowUserReqVO unfollowUserReqVO) {
        return relationService.unfollow(unfollowUserReqVO);
    }

    @PostMapping("/following/list")
    public PageResult<FindFollowingUserRspVO> findFollowingList(@Valid @RequestBody FindFollowingListReqVO findFollowingListReqVO) {
        return relationService.findFollowingList(findFollowingListReqVO);
    }

    @PostMapping("/fans/list")
    public PageResult<FindFansUserRspVO> findFansList(@Valid @RequestBody FindFansListReqVO findFansListReqVO) {
        return relationService.findFansList(findFansListReqVO);
    }
}