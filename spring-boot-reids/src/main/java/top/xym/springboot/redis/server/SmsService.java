package top.xym.springboot.redis.server;

public interface SmsService {
    /**
     * 发送短信
     *
     * @param phone 手机号
     */
    void sendSms(String phone);
}
