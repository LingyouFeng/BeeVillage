package com.beevillage.count.biz.domain.mapper;

import com.beevillage.count.biz.domain.dataobject.NoteLikeDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteLikeDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NoteLikeDO record);

    int insertSelective(NoteLikeDO record);

    NoteLikeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteLikeDO record);

    int updateByPrimaryKey(NoteLikeDO record);
}