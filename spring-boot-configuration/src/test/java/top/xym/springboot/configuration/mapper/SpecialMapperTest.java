package top.xym.springboot.configuration.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.springboot.configuration.entity.Special;

import java.util.List;

@SpringBootTest
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;

    @Test
    void findAll() {
        List<Special> specials = specialMapper.findAll();
        specials.forEach(System.out::println);
    }

}