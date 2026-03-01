package com.beevillage.auth.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jason Feng
 * @since 2026-02-01 11:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendVerificationCodeVO {

    @NotBlank(message = "手机号不能为空")
    private String phone;
}
