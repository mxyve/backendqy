package top.xym.springboot.configuration.entity;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class PersonTest {
    @Resource
    private Person person;

    @Test
    public void testPerson() {
        log.info(person.toString());
    }
}