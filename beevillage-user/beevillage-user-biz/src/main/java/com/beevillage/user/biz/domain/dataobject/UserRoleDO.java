package com.beevillage.user.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_user_role_rel 表实体类
 *
 * @since 2026-02-01 16:00
 * @author Jason Feng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDO implements Serializable {

    private Long id;

    private Long userId;

    private Long roleId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;
}