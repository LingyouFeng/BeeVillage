package com.beevillage.note.biz.domain.mapper;

import com.beevillage.note.biz.domain.dataobject.ChannelTopicRelDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 频道话题 Mapper 类
 *
 * @since 2026-03-04 21:26
 * @author Jason Feng
 */
@Mapper
public interface ChannelTopicRelDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ChannelTopicRelDO record);

    int insertSelective(ChannelTopicRelDO record);

    ChannelTopicRelDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelTopicRelDO record);

    int updateByPrimaryKey(ChannelTopicRelDO record);
}