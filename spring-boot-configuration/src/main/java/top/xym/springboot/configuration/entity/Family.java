package top.xym.springboot.configuration.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Family {
    @Value("${family.family-name")
    private String familyName;

    @Value("${family.father}")
    private String father;

    @Value("${family.mother}")
    private String mother;

    @Value("${family.child}")
    private String child;
}
