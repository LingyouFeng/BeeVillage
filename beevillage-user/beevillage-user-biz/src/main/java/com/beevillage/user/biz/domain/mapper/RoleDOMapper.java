package com.beevillage.user.biz.domain.mapper;


import com.beevillage.user.biz.domain.dataobject.RoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * RoleDOMapper
 *
 * @since 2026-02-01 17:14
 * @author Jason Feng
 */
@Mapper
public interface RoleDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    RoleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);

    /**
     * 查询所有被启用的角色
     *
     * @return
     */
    List<RoleDO> selectEnabledList();
}