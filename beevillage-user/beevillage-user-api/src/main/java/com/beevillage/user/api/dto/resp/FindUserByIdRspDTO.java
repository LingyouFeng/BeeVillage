package com.beevillage.user.api.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  用户信息
 *
 * @author Jason Feng
 * @since 2026-03-05 22:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserByIdRspDTO {

    /**
     * 用户 ID
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;
}