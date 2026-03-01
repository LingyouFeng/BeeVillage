package com.beevillage.user.biz.rpc;

import com.beevillage.leaf.api.feign.LeafFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 分布式 ID 生成服务
 *
 * @author Jason Feng
 * @since 2026-03-01 21:28
 */
@Component
public class LeafRpcService {

    @Resource
    private LeafFeignApi leafFeignApi;

    /**
     * Leaf 号段模式：蜜蜂村 ID 业务标识
     */
    private static final String BIZ_TAG_BEEVILLAGE_ID = "leaf-segment-beevillage-id";

    /**
     * Leaf 号段模式：用户 ID 业务标识
     */
    private static final String BIZ_TAG_USER_ID = "leaf-segment-user-id";

    /**
     * 调用分布式 ID 生成服务生成蜜蜂村 ID
     *
     * @return      蜜蜂村用户 ID
     */
    public String getBeevillageId() {
        return leafFeignApi.getSegmentId(BIZ_TAG_BEEVILLAGE_ID);
    }

    /**
     * 调用分布式 ID 生成服务用户 ID
     *
     * @return
     */
    public String getUserId() {
        return leafFeignApi.getSegmentId(BIZ_TAG_USER_ID);
    }
}
