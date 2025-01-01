package top.xym.springboot.configuration.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family") // 表示配置的整体前缀
public class Family {
//    @Value("${family.family-name}")
    @Length(min = 5, max = 20, message = "家庭名长度必须位于5到20之间")
    private String familyName;

//    @Value("${family.father}")
    private String father;

//    @Value("${family.mother}")
    private String mother;

//    @Value("${family.child}")
    private String child;

    @Range(min = 3, message = "必须大于3年！")
    private Integer age;
}
