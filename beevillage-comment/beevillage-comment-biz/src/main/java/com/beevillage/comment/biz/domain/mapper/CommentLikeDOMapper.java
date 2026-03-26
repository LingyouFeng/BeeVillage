package com.beevillage.comment.biz.domain.mapper;

import com.beevillage.comment.biz.domain.dataobject.CommentLikeDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentLikeDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CommentLikeDO record);

    int insertSelective(CommentLikeDO record);

    CommentLikeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentLikeDO record);

    int updateByPrimaryKey(CommentLikeDO record);
}