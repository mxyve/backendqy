package top.xym.springboot.redis.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.redis.result.Result;
import top.xym.springboot.redis.service.UserService;
import top.xym.springboot.redis.vo.UserLoginVO;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "手机短信登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone") String phone,
                                            @RequestParam("code") String code) {
        return Result.ok(userService.loginByPhone(phone, code));
    }
}
