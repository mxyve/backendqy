package top.xym.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"top.xym.springboot.mybatis.mapper"})
public class Applicaiton {
    public static void main(String[] args) {
        SpringApplication.run(Applicaiton.class, args);
    }
}
