package com.beevillage.count.biz.domain.mapper;

import com.beevillage.count.biz.domain.dataobject.NoteCollectionDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteCollectionDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NoteCollectionDO record);

    int insertSelective(NoteCollectionDO record);

    NoteCollectionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteCollectionDO record);

    int updateByPrimaryKey(NoteCollectionDO record);
}