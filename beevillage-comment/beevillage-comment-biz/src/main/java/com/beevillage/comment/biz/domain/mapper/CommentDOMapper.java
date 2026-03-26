package com.beevillage.comment.biz.domain.mapper;

import com.beevillage.comment.biz.domain.dataobject.CommentDO;
import com.beevillage.comment.biz.model.bo.CommentBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CommentDO record);

    int insertSelective(CommentDO record);

    CommentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentDO record);

    int updateByPrimaryKey(CommentDO record);

    /**
     * 根据评论 ID 批量查询
     * @param commentIds
     * @return
     */
    List<CommentDO> selectByCommentIds(@Param("commentIds") List<Long> commentIds);

    /**
     * 批量插入评论
     * @param comments
     * @return
     */
    int batchInsert(@Param("comments") List<CommentBO> comments);
}