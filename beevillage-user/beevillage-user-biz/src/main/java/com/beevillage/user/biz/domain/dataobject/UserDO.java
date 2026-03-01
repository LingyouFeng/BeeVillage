package com.beevillage.user.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * t_user 表实体类
 *
 * @since 2026-02-01 16:00
 * @author Jason Feng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO implements Serializable {

    private Long id;

    private String beevillageId;

    private String phone;

    private String password;

    private String avatar;

    private String nickname;

    private Integer gender;

    private LocalDate birthday;

    private String backgroundImg;

    private Integer status;

    private String introduction;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;
}