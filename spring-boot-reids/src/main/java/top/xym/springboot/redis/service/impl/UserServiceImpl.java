package top.xym.springboot.redis.service.impl;

import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import top.xym.springboot.redis.cache.TokenStoreCache;
import top.xym.springboot.redis.config.RedisCache;
import top.xym.springboot.redis.config.RedisKeys;
import top.xym.springboot.redis.entity.User;
import top.xym.springboot.redis.enums.AccountStatusEnum;
import top.xym.springboot.redis.enums.ErrorCode;
import top.xym.springboot.redis.exception.ServerException;
import top.xym.springboot.redis.mapper.UserMapper;
import top.xym.springboot.redis.service.UserService;
import top.xym.springboot.redis.utils.JwtUtil;
import top.xym.springboot.redis.vo.UserLoginVO;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final RedisCache redisCache;
    private final TokenStoreCache tokenStoreCache;

    @Override
    public UserLoginVO loginByPhone(String phone, String code) {
        // 获取验证码cacheKey
        String smsCacheKey = RedisKeys.getSmsKey(phone);
        // 从redis中获取验证码
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
        // 校验验证码合法性
        if (ObjectUtils.isEmpty(redisCode) || !redisCode.toString().equals(code)) {
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        // 删除用过的验证码
        redisCache.delete(smsCacheKey);
        // 根据手机号获取用户
        User user = baseMapper.getByPhone(phone);
        // 判断用户是否注册过，如果user为空代表未注册，进行注册。否则开启登录流程
        if (ObjectUtils.isEmpty(user)) {
            log.info("用户不存在，创建用户,phone: {}", phone);
            user = new User();
            user.setNickname(phone);
            user.setPhone(phone);
            user.setAvatar("https://mxy-u.oss-cn-nanjing.aliyuncs.com/undefined%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20240927182331.jpg");
            user.setGender(0);
            user.setEnabled(AccountStatusEnum.ENABLED.getValue());
            user.setBonus(100);
            user.setDeleteFlag(0);
            user.setRemark("这个人很懒，什么都没有写");
            baseMapper.insert(user);
        }
        // 用户被禁用
        if (!user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue())) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }
        // 构造token
        String accessToken = JwtUtil.createToken(user.getPkId());
        // 构造登陆返回
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setPkId(user.getPkId());
        userLoginVO.setPhone(user.getPhone());
        userLoginVO.setAccessToken(accessToken);
        tokenStoreCache.saveUser(accessToken, userLoginVO);
        return userLoginVO;
    }
}


















