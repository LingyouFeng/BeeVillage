package com.beevillage.user.relation.biz.service;

import com.beevillage.common.response.PageResult;
import com.beevillage.common.response.Result;
import com.beevillage.user.relation.biz.model.vo.*;

/**
 * 关注业务
 *
 * @author Jason Feng
 * @since 2026-03-10 10:53
 */
public interface RelationService {

    /**
     * 关注用户
     * @param followUserReqVO
     * @return
     */
    Result<?> follow(FollowUserReqVO followUserReqVO);

    /**
     * 取关用户
     * @param unfollowUserReqVO
     * @return
     */
    Result<?> unfollow(UnfollowUserReqVO unfollowUserReqVO);

    /**
     * 查询关注列表
     * @param findFollowingListReqVO
     * @return
     */
    PageResult<FindFollowingUserRspVO> findFollowingList(FindFollowingListReqVO findFollowingListReqVO);

    /**
     * 查询粉丝列表
     * @param findFansListReqVO
     * @return
     */
    PageResult<FindFansUserRspVO> findFansList(FindFansListReqVO findFansListReqVO);
}
