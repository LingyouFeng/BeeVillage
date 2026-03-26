package com.beevillage.comment.biz.rpc;

import com.beevillage.leaf.api.feign.LeafFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 分布式 ID 服务
 *
 * @author Jason Feng
 * @since 2026-03-05 20:44
 */
@Component
public class LeafRpcService {

    @Resource
    private LeafFeignApi leafFeignApi;

    /**
     * 生成评论 ID
     *
     * @return  分布式 id
     */
    public String generateCommentId() {
        return leafFeignApi.getSegmentId("leaf-segment-comment-id");
    }
}
