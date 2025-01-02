package top.xym.springboot.configuration.entity;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.List;
import java.util.Map;

@Data
@Configuration
@PropertySource(name = "employeeProperties", value = "classpath:employee.properties", encoding = "utf-8")
public class Employee {

    /**
     * 使用 SpEL 读取 employee.properties 配置文件
     */
    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split(',')[0]}")
    private String firstEmployeeName;

    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAge;

//    @Value("#{${employee.age}.two}")
     @Value ("#{${employee.age}['two']}")  //这样写也可以
    private String employeeAgeTwo;

    @Value("#{${employee.age}['three'] != null ? ${employee.age}['three']: 30}")
    private Integer ageWithDefaultValue;

}
