package com.beevillage.auth.controller;

import com.beevillage.auth.model.SendVerificationCodeVO;
import com.beevillage.auth.service.VerificationCodeService;
import com.beevillage.common.response.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码接口
 *
 * @author Jason Feng
 * @since 2026-02-01 11:40
 */
@Slf4j
@RestController
@RequestMapping("/verification")
public class VerificationCodeController {

    @Resource
    private VerificationCodeService verificationCodeService;

    @PostMapping("/code/send")
    public Result<?> send(@RequestBody @Valid SendVerificationCodeVO sendVerificationCodeVO) {
        return verificationCodeService.send(sendVerificationCodeVO);
    }
}
