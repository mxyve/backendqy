package top.xym.springboot.hutool.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.hutool.service.LogService;

@RestController
@AllArgsConstructor
public class LogController {
    private final LogService logService;

    @GetMapping("/log")
    public void logMessage() {
        logService.logMessage();
    }
}
