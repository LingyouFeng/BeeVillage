package com.beevillage.data.align.domain.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 删除表
 *
 * @author Jason Feng
 * @since 2026-03-17 11:31
 */
@Mapper
public interface DeleteTableMapper {

    /**
     * 删除日增量表：关注数计数变更
     * @param tableNameSuffix
     */
    void deleteDataAlignFollowingCountTempTable(String tableNameSuffix);

    /**
     * 删除日增量表：粉丝数计数变更
     * @param tableNameSuffix
     */
    void deleteDataAlignFansCountTempTable(String tableNameSuffix);

    /**
     * 删除日增量表：笔记收藏数计数变更
     * @param tableNameSuffix
     */
    void deleteDataAlignNoteCollectCountTempTable(String tableNameSuffix);

    /**
     * 删除日增量表：用户被收藏数计数变更
     * @param tableNameSuffix
     */
    void deleteDataAlignUserCollectCountTempTable(String tableNameSuffix);

    /**
     * 删除日增量表：用户被点赞数计数变更
     * @param tableNameSuffix
     */
    void deleteDataAlignUserLikeCountTempTable(String tableNameSuffix);

    /**
     * 删除日增量表：笔记点赞数计数变更
     * @param tableNameSuffix
     */
    void deleteDataAlignNoteLikeCountTempTable(String tableNameSuffix);

    /**
     * 删除日增量表：笔记发布数计数变更
     * @param tableNameSuffix
     */
    void deleteDataAlignNotePublishCountTempTable(String tableNameSuffix);
}
