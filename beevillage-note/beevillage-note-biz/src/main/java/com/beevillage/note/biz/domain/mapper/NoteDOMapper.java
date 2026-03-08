package com.beevillage.note.biz.domain.mapper;

import com.beevillage.note.biz.domain.dataobject.NoteDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 笔记 Mapper 类
 *
 * @since 2026-03-04 21:26
 * @author Jason Feng
 */
@Mapper
public interface NoteDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NoteDO record);

    int insertSelective(NoteDO record);

    NoteDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteDO record);

    int updateByPrimaryKey(NoteDO record);

    int updateVisibleOnlyMe(NoteDO noteDO);

    int updateIsTop(NoteDO noteDO);
}