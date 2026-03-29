package com.beevillage.comment.biz.domain.mapper;

import com.beevillage.comment.biz.domain.dataobject.NoteCountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteCountDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NoteCountDO record);

    int insertSelective(NoteCountDO record);

    NoteCountDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteCountDO record);

    int updateByPrimaryKey(NoteCountDO record);

    /**
     * 查询笔记评论总数
     * @param noteId
     * @return
     */
    Long selectCommentTotalByNoteId(Long noteId);
}