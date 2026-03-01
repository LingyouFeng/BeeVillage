package com.beevillage.user.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_role 表实体类
 *
 * @since 2026-02-01 16:00
 * @author Jason Feng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDO implements Serializable {

    private Long id;

    private String roleName;

    private String roleKey;

    private Integer status;

    private Integer sort;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;
}