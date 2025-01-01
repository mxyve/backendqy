package top.xym.springboot.configuration.entity;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Data
public class User {

    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;

    @Min(18)
    @Max(100)
    private int age;

    // 匹配一个精确⻓度为 11 位的数字字符串。即该字符串必须由 11 个数字组成，
    // 并且不能有其他字符（如空格、字母或符号）
    @Pattern(regexp = "^[0-9]{11}")
    private String phoneNumber;

    @Future
    private LocalDate subscriptionEndDate;

    @Positive
    private int score;

    @URL
    private String website;
}
