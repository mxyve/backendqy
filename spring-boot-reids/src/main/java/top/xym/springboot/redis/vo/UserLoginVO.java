package top.xym.springboot.redis.vo;
// 封装返回给客户端的参数

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(description = "用户登录vo")
public class UserLoginVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8212240698099812005L;

    @Schema(description = "⽤户 ID")
    private Long pkId;

    @Schema(description = "⼿机号 ")
    private String phone;

    @Schema(description = " 令牌 ")
    private String accessToken;
}
