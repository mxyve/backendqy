package top.xym.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        // Model：Spring MVC 提供的对象，用于将数据传递到前端页面
        // 将 “message” 属性传递到视图
        model.addAttribute("message", "Hello, World!");
        // 返回视图名称 “hello”(即 hello.html 页面)
        return "hello";
    }
}
