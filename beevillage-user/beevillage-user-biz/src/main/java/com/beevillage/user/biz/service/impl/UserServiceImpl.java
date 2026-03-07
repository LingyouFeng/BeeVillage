package com.beevillage.user.biz.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.beevillage.common.enums.DeletedEnum;
import com.beevillage.common.enums.StatusEnum;
import com.beevillage.common.exception.BusinessException;
import com.beevillage.common.response.Result;
import com.beevillage.common.utils.ParamUtils;
import com.beevillage.context.holder.LoginUserContextHolder;
import com.beevillage.user.api.dto.req.FindUserByIdReqDTO;
import com.beevillage.user.api.dto.req.FindUserByPhoneReqDTO;
import com.beevillage.user.api.dto.req.RegisterUserReqDTO;
import com.beevillage.user.api.dto.req.UpdateUserPasswordReqDTO;
import com.beevillage.user.api.dto.resp.FindUserByIdRspDTO;
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
import com.beevillage.user.biz.rpc.LeafRpcService;
import com.beevillage.user.biz.rpc.OssRpcService;
import com.beevillage.user.biz.service.UserService;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private LeafRpcService leafRpcService;
    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 用户信息本地缓存
     */
    private static final Cache<Long, FindUserByIdRspDTO> LOCAL_CACHE = Caffeine.newBuilder()
            .initialCapacity(10000) // 设置初始容量为 10000 个条目
            .maximumSize(10000) // 设置缓存的最大容量为 10000 个条目
            .expireAfterWrite(1, TimeUnit.HOURS) // 设置缓存条目在写入后 1 小时过期
            .build();

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
        // Long beevillageId = redisTemplate.opsForValue().increment(RedisKeyConstants.ID_GENERATOR);

        // RPC: 调用分布式 ID 生成服务生成小哈书 ID
        String beevillageId = leafRpcService.getBeevillageId();

        // RPC: 调用分布式 ID 生成服务生成用户 ID
        String userIdStr = leafRpcService.getUserId();
        Long userId = Long.valueOf(userIdStr);

        UserDO userDO = UserDO.builder()
                .id(userId)
                .phone(phone)
                .beevillageId(String.valueOf(beevillageId))
                .nickname("蜜蜂村" + beevillageId)
                .status(StatusEnum.ENABLE.getValue())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .deleted(DeletedEnum.NO.getValue())
                .build();

        // 添加入库
        userDOMapper.insertSelective(userDO);

        // 获取刚刚添加入库的用户 ID
        // Long userId = userDO.getId();

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

    @Override
    public Result<FindUserByIdRspDTO> findById(FindUserByIdReqDTO findUserByIdReqDTO) {
        Long userId = findUserByIdReqDTO.getId();

        // 先从本地缓存中查询
        FindUserByIdRspDTO findUserByIdRspDTOLocalCache = LOCAL_CACHE.getIfPresent(userId);
        if (Objects.nonNull(findUserByIdRspDTOLocalCache)) {
            log.info("==> 命中了本地缓存；{}", findUserByIdRspDTOLocalCache);
            return Result.success(findUserByIdRspDTOLocalCache);
        }

        // 用户缓存 Redis Key
        String userInfoRedisKey = RedisKeyConstants.buildUserInfoKey(userId);

        // 先从 Redis 缓存中查询
        String userInfoRedisValue = (String) redisTemplate.opsForValue().get(userInfoRedisKey);

        // 若 Redis 缓存中存在该用户信息
        if (StringUtils.isNotBlank(userInfoRedisValue)) {
            // 将存储的 Json 字符串转换成对象，并返回
            FindUserByIdRspDTO findUserByIdRspDTO = JSON.parseObject(userInfoRedisValue, FindUserByIdRspDTO.class);
            // 异步线程中将用户信息存入本地缓存
            threadPoolTaskExecutor.submit(() -> {
                if (Objects.nonNull(findUserByIdRspDTO)) {
                    // 写入本地缓存
                    LOCAL_CACHE.put(userId, findUserByIdRspDTO);
                }
            });
            return Result.success(findUserByIdRspDTO);
        }

        // 否则, 从数据库中查询
        // 根据用户 ID 查询用户信息
        UserDO userDO = userDOMapper.selectByPrimaryKey(userId);

        // 判空
        if (Objects.isNull(userDO)) {
            threadPoolTaskExecutor.execute(() -> {
                // 防止缓存穿透，将空数据存入 Redis 缓存 (过期时间不宜设置过长)
                // 保底1分钟 + 随机秒数
                long expireSeconds = 60 + RandomUtil.randomInt(60);
                redisTemplate.opsForValue().set(userInfoRedisKey, "null", expireSeconds, TimeUnit.SECONDS);
            });
            throw new BusinessException(UserResultCodeEnum.USER_NOT_FOUND);
        }

        // 构建返参
        FindUserByIdRspDTO findUserByIdRspDTO = FindUserByIdRspDTO.builder()
                .id(userDO.getId())
                .nickName(userDO.getNickname())
                .avatar(userDO.getAvatar())
                .build();


        // 异步将用户信息存入 Redis 缓存，提升响应速度
        threadPoolTaskExecutor.submit(() -> {
            // 过期时间（保底1天 + 随机秒数，将缓存过期时间打散，防止同一时间大量缓存失效，导致数据库压力太大）
            long expireSeconds = 60*60*24 + RandomUtil.randomInt(60*60*24);
            redisTemplate.opsForValue()
                    .set(userInfoRedisKey, JSON.toJSONString(findUserByIdRspDTO), expireSeconds, TimeUnit.SECONDS);
        });

        return Result.success(findUserByIdRspDTO);
    }
}
