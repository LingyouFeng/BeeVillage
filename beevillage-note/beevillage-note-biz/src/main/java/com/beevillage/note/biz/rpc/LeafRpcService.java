package com.beevillage.note.biz.rpc;

import com.beevillage.leaf.api.feign.LeafFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jason Feng
 * @since 2026-03-05 20:44
 */
@Component
public class LeafRpcService {

    @Resource
    private LeafFeignApi leafFeignApi;

    /**
     * 生成雪花算法 ID
     *
     * @return  分布式 id
     */
    public String getSnowflakeId() {
        return leafFeignApi.getSnowflakeId("test");
    }

}
