package top.xym.springboot.configuration.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.configuration.entity.Special;
import top.xym.springboot.configuration.mapper.SpecialMapper;

import java.util.List;

@RestController
public class SpecialController {
    @Resource
    private SpecialMapper specialMapper;

    @GetMapping("/specials")
    public List<Special> getSpecial() {
        return specialMapper.findAll();
    }
}
