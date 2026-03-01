package com.beevillage.auth.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.beevillage.auth.model.SendVerificationCodeVO;
import com.beevillage.auth.service.VerificationCodeService;
import com.beevillage.common.response.Result;
import com.beevillage.auth.constant.RedisKeyConstants;
import com.beevillage.common.enums.GlobalResultCodeEnum;
import com.beevillage.common.exception.BusinessException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jason Feng
 * @since 2026-02-01 11:27
 */
@Slf4j
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 发送短信验证码
     *
     * @param sendVerificationCodeVO   用户手机号
     * @return                          请求响应结果
     */
    @Override
    public Result<?> send(SendVerificationCodeVO sendVerificationCodeVO) {
        // 手机号
        String phone = sendVerificationCodeVO.getPhone();

        // 构建验证码 redis key
        String key = RedisKeyConstants.buildVerificationCodeKey(phone);

        // 判断是否已发送验证码
        boolean isSent = redisTemplate.hasKey(key);
        if (isSent) {
            // 若之前发送的验证码未过期，则提示发送频繁
            throw new BusinessException(GlobalResultCodeEnum.REQUEST_FREQUENTLY);
        }

        // 生成 6 位随机数字验证码
        String verificationCode = RandomUtil.randomNumbers(6);

        // todo: 调用第三方短信发送服务

        log.info("==> 手机号: {}, 已发送验证码：【{}】", phone, verificationCode);

        // 存储验证码到 redis, 并设置过期时间为 3 分钟
        redisTemplate.opsForValue().set(key, verificationCode, 1, TimeUnit.MINUTES);

        return Result.success();
    }

}
