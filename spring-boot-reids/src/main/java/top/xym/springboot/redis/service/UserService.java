package top.xym.springboot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.xym.springboot.redis.entity.User;
import top.xym.springboot.redis.vo.UserLoginVO;

public interface UserService extends IService<User> {
    /**
     * 登录
     *
     * @param phone 电话
     * @param code 验证码
     * @return {@link UserLoginVO}
     */
    UserLoginVO loginByPhone(String phone, String code);
}
