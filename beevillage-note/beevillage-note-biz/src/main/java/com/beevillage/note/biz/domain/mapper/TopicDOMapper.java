package com.beevillage.note.biz.domain.mapper;

import com.beevillage.note.biz.domain.dataobject.TopicDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 话题 Mapper 类
 *
 * @since 2026-03-04 21:26
 * @author Jason Feng
 */
@Mapper
public interface TopicDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TopicDO record);

    int insertSelective(TopicDO record);

    TopicDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicDO record);

    int updateByPrimaryKey(TopicDO record);

    String selectNameByPrimaryKey(Long id);
}