package com.beevillage.user.relation.biz.domain.mapper;

import com.beevillage.user.relation.biz.domain.dataobject.FollowingDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 关注 Mapper类
 *
 * @author Jason Feng
 * @since 2026-03-09 23:17
 */
@Mapper
public interface FollowingDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FollowingDO record);

    int insertSelective(FollowingDO record);

    FollowingDO selectByPrimaryKey(Long id);

    List<FollowingDO> selectByUserId(Long userId);

    int updateByPrimaryKeySelective(FollowingDO record);

    int updateByPrimaryKey(FollowingDO record);

    int deleteByUserIdAndFollowingUserId(@Param("userId") Long userId,
                                         @Param("unfollowUserId") Long unfollowUserId);

    /**
     * 查询记录总数
     *
     * @param userId
     * @return
     */
    long selectCountByUserId(Long userId);

    /**
     * 分页查询
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    List<FollowingDO> selectPageListByUserId(@Param("userId") Long userId,
                                             @Param("offset") long offset,
                                             @Param("limit") long limit);

    /**
     * 查询关注用户列表
     * @param userId
     * @return
     */
    List<FollowingDO> selectAllByUserId(Long userId);
}