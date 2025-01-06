package top.xym.springboot.redis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaviconController {
    @RequestMapping("/favicon.ico")
    public ResponseEntity<Object> favicon() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
