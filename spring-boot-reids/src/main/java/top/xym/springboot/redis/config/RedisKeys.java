package top.xym.springboot.redis.config;
// 维护Redis 存储的键
public class RedisKeys {

    /**
     * 验证码 Key
     */
    public static String getSmsKey(String phone) {
        return "sms:captcha:" + phone;
    }
}
