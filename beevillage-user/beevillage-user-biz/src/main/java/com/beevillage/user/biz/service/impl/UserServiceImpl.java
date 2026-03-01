package com.beevillage.user.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.beevillage.common.enums.DeletedEnum;
import com.beevillage.common.enums.StatusEnum;
import com.beevillage.common.exception.BusinessException;
import com.beevillage.common.response.Result;
import com.beevillage.common.utils.ParamUtils;
import com.beevillage.context.holder.LoginUserContextHolder;
import com.beevillage.user.api.dto.req.FindUserByPhoneReqDTO;
import com.beevillage.user.api.dto.req.RegisterUserReqDTO;
import com.beevillage.user.api.dto.req.UpdateUserPasswordReqDTO;
import com.beevillage.user.api.dto.resp.FindUserByPhoneRspDTO;
import com.beevillage.user.biz.constant.RedisKeyConstants;
import com.beevillage.user.biz.constant.RoleConstants;
import com.beevillage.user.biz.domain.dataobject.RoleDO;
import com.beevillage.user.biz.domain.dataobject.UserDO;
import com.beevillage.user.biz.domain.dataobject.UserRoleDO;
import com.beevillage.user.biz.domain.mapper.RoleDOMapper;
import com.beevillage.user.biz.domain.mapper.UserDOMapper;
import com.beevillage.user.biz.domain.mapper.UserRoleDOMapper;
import com.beevillage.user.biz.enums.SexEnum;
import com.beevillage.user.biz.enums.UserResultCodeEnum;
import com.beevillage.user.biz.model.UpdateUserInfoReqVO;
import com.beevillage.user.biz.rpc.OssRpcService;
import com.beevillage.user.biz.service.UserService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户服务实现类
 *
 * @author Jason Feng
 * @since 2026-02-21 16:46
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDOMapper userDOMapper;
    @Resource
    private RoleDOMapper roleDOMapper;
    @Resource
    private UserRoleDOMapper userRoleDOMapper;
    @Resource
    private OssRpcService ossRpcService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO   更新的用户信息数据
     * @return                      响应结果
     */
    @Override
    public Result<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO) {
        UserDO userDO = new UserDO();
        // 设置当前需要更新的用户 ID
        userDO.setId(LoginUserContextHolder.getUserId());
        // 标识位：是否需要更新
        boolean needUpdate = false;

        // 头像
        MultipartFile avatarFile = updateUserInfoReqVO.getAvatar();

        if (Objects.nonNull(avatarFile)) {
            String avatar = ossRpcService.uploadFile(avatarFile);
            log.info("==> 调用 oss 服务成功，上传头像，url：{}", avatar);

            // 若上传头像失败，则抛出业务异常
            if (StringUtils.isBlank(avatar)) {
                throw new BusinessException(UserResultCodeEnum.UPLOAD_AVATAR_FAIL);
            }

            userDO.setAvatar(avatar);
            needUpdate = true;
        }

        // 昵称
        String nickname = updateUserInfoReqVO.getNickname();
        if (StringUtils.isNotBlank(nickname)) {
            Preconditions.checkArgument(ParamUtils.checkNickname(nickname),
                    UserResultCodeEnum.NICK_NAME_VALID_FAIL.getMessage());
            userDO.setNickname(nickname);
            needUpdate = true;
        }

        // 用户个人id
        String beevillageId = updateUserInfoReqVO.getBeevillageId();
        if (StringUtils.isNotBlank(beevillageId)) {
            Preconditions.checkArgument(ParamUtils.checkUserId(beevillageId),
                    UserResultCodeEnum.BEEVILLAGE_ID_VALID_FAIL.getMessage());
            userDO.setBeevillageId(beevillageId);
            needUpdate = true;
        }

        // 性别
        Integer sex = updateUserInfoReqVO.getGender();
        if (Objects.nonNull(sex)) {
            Preconditions.checkArgument(SexEnum.isValid(sex),
                    UserResultCodeEnum.SEX_VALID_FAIL.getMessage());
            userDO.setGender(sex);
            needUpdate = true;
        }

        // 生日
        LocalDate birthday = updateUserInfoReqVO.getBirthday();
        if (Objects.nonNull(birthday)) {
            userDO.setBirthday(birthday);
            needUpdate = true;
        }

        // 个人简介
        String introduction = updateUserInfoReqVO.getIntroduction();
        if (StringUtils.isNotBlank(introduction)) {
            Preconditions.checkArgument(ParamUtils.checkLength(introduction, 100),
                    UserResultCodeEnum.INTRODUCTION_VALID_FAIL.getMessage());
            userDO.setIntroduction(introduction);
            needUpdate = true;
        }

        // 背景图
        MultipartFile backgroundImgFile = updateUserInfoReqVO.getBackgroundImg();
        if (Objects.nonNull(backgroundImgFile)) {
            String backgroundImg = ossRpcService.uploadFile(backgroundImgFile);
            log.info("==> 调用 oss 服务成功，上传背景图，url：{}", backgroundImg);

            // 若上传背景图失败，则抛出业务异常
            if (StringUtils.isBlank(backgroundImg)) {
                throw new BusinessException(UserResultCodeEnum.UPLOAD_BACKGROUND_IMG_FAIL);
            }

            userDO.setBackgroundImg(backgroundImg);
            needUpdate = true;
        }

        if (needUpdate) {
            // 更新用户信息
            userDO.setUpdateTime(LocalDateTime.now());
            userDOMapper.updateByPrimaryKeySelective(userDO);
        }
        return Result.success();
    }


    @Override
    public Result<Long> register(RegisterUserReqDTO registerUserReqDTO) {
        String phone = registerUserReqDTO.getPhone();

        // 先判断该手机号是否已被注册
        UserDO userDO1 = userDOMapper.selectByPhone(phone);

        log.info("==> 用户是否注册, phone: {}, userDO: {}", phone, JSON.toJSONString(userDO1));

        // 若已注册，则直接返回用户 ID
        if (Objects.nonNull(userDO1)) {
            return Result.success(userDO1.getId());
        }

        // 否则注册新用户
        // 获取全局自增的蜜蜂村 ID
        Long beevillageId = redisTemplate.opsForValue().increment(RedisKeyConstants.ID_GENERATOR);

        UserDO userDO = UserDO.builder()
                .phone(phone)
                .beevillageId(String.valueOf(beevillageId))
                .nickname("小红薯" + beevillageId)
                .status(StatusEnum.ENABLE.getValue())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .deleted(DeletedEnum.NO.getValue())
                .build();

        // 添加入库
        userDOMapper.insertSelective(userDO);

        // 获取刚刚添加入库的用户 ID
        Long userId = userDO.getId();

        // 给该用户分配一个默认角色
        UserRoleDO userRoleDO = UserRoleDO.builder()
                .userId(userId)
                .roleId(RoleConstants.COMMON_USER_ROLE_ID)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .deleted(DeletedEnum.NO.getValue())
                .build();
        userRoleDOMapper.insert(userRoleDO);

        RoleDO roleDO = roleDOMapper.selectByPrimaryKey(RoleConstants.COMMON_USER_ROLE_ID);

        // 将该用户的角色 ID 存入 Redis 中

        List<String> roles = new ArrayList<>(1);
        roles.add(roleDO.getRoleKey());

        String userRolesKey = RedisKeyConstants.buildUserRoleKey(userId);
        redisTemplate.opsForValue().set(userRolesKey, JSON.toJSONString(roles));

        return Result.success(userId);
    }

    @Override
    public Result<FindUserByPhoneRspDTO> findByPhone(FindUserByPhoneReqDTO findUserByPhoneReqDTO) {
        String phone = findUserByPhoneReqDTO.getPhone();

        // 根据手机号查询用户信息
        UserDO userDO = userDOMapper.selectByPhone(phone);

        // 判空
        if (Objects.isNull(userDO)) {
            throw new BusinessException(UserResultCodeEnum.USER_NOT_FOUND);
        }

        // 构建返参
        FindUserByPhoneRspDTO findUserByPhoneRspDTO = FindUserByPhoneRspDTO.builder()
                .id(userDO.getId())
                .password(userDO.getPassword())
                .build();

        return Result.success(findUserByPhoneRspDTO);
    }

    @Override
    public Result<?> updatePassword(UpdateUserPasswordReqDTO updateUserPasswordReqDTO) {
        // 获取当前请求对应的用户 ID
        Long userId = LoginUserContextHolder.getUserId();

        UserDO userDO = UserDO.builder()
                .id(userId)
                .password(updateUserPasswordReqDTO.getEncodePassword())
                .updateTime(LocalDateTime.now())
                .build();
        // 更新密码
        userDOMapper.updateByPrimaryKeySelective(userDO);

        return Result.success();
    }
}
