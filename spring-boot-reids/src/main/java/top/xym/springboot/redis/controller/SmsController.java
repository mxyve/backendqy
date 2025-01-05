package top.xym.springboot.redis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.redis.result.Result;
import top.xym.springboot.redis.server.SmsService;

@RestController
@RequestMapping("/sms")
@AllArgsConstructor
public class SmsController {
    private final SmsService smsService;

    @PostMapping("/send")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        smsService.sendSms(phone);
        return Result.ok();
    }
}
