package com.beevillage.user.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_permission表实体类
 *
 * @since 2026-02-01 16:00
 * @author Jason Feng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDO implements Serializable {

    private Long id;

    private Long parentId;

    private String name;

    private Integer type;

    private String menuUrl;

    private String menuIcon;

    private Integer sort;

    private String permissionKey;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;
}