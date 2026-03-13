package com.beevillage.user.relation.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 粉丝类
 *
 * @author Jason Feng
 * @since 2026-03-09 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FansDO {

    private Long id;

    private Long userId;

    private Long fansUserId;

    private LocalDateTime createTime;
}