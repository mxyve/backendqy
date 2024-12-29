package top.xym.springboot.quickstart;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//// Spring Boot 启动分析
//        SpringApplication springApplication = new SpringApplication(Application.class);
//
//        // 关闭图案
//        springApplication.setBannerMode(Banner.Mode.OFF);
//
//        // 关闭启动日志
//        springApplication.setLogStartupInfo(false);
//
//        springApplication.run(args);
    }

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
