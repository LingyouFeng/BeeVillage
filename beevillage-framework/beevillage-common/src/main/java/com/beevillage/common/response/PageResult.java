package com.beevillage.common.response;

import com.beevillage.common.enums.GlobalResultCodeEnum;
import lombok.Data;

import java.util.List;

/**
 * 分页响应参数工具类
 *
 * @author Jason Feng
 * @since 2026-03-12 20:49
 */
@Data
public class PageResult<T> extends Result<List<T>> {
    
    private long pageNo; // 当前页码
    private long totalCount; // 总数据量
    private long pageSize; // 每页展示的数据量
    private long totalPage; // 总页数

    public static <T> PageResult<T> success(List<T> data, long pageNo, long totalCount) {
        return success(data, pageNo, totalCount, 10);
    }

    public static <T> PageResult<T> success(List<T> data, long pageNo, long totalCount, long pageSize) {
        PageResult<T> PageResult = new PageResult<>();
        PageResult.setSuccess(true);
        PageResult.setCode(GlobalResultCodeEnum.SUCCESS.getCode());
        PageResult.setMessage(GlobalResultCodeEnum.SUCCESS.getMessage());
        PageResult.setData(data);
        PageResult.setPageNo(pageNo);
        PageResult.setTotalCount(totalCount);
        PageResult.setPageSize(pageSize);
        // 计算总页数
        long totalPage = getTotalPage(totalCount, pageSize);
        PageResult.setTotalPage(totalPage);
        return PageResult;
    }

    /**
     * 获取总页数
     * @return
     */
    public static long getTotalPage(long totalCount, long pageSize) {
        return pageSize == 0 ? 0 : (totalCount + pageSize - 1) / pageSize;
    }

    /**
     * 计算分页查询的 offset
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static long getOffset(long pageNo, long pageSize) {
        // 如果页码小于 1，默认返回第一页的 offset
        if (pageNo < 1) {
            pageNo = 1;
        }
        return (pageNo - 1) * pageSize;
    }
}
