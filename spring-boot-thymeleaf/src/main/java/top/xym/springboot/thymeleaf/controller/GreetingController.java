package top.xym.springboot.thymeleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return sayHello(name);
    }

    private String sayHello(String name) {
        String greeting = "Hello, " + name;
        return greeting;
    }
}
