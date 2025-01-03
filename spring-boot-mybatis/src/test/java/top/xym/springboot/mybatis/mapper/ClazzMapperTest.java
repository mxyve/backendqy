package top.xym.springboot.mybatis.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.springboot.mybatis.entity.Clazz;

@SpringBootTest
@Slf4j
class ClazzMapperTest {
    @Resource
    private ClazzMapper clazzMapper;

    @Test
    void getClazzOneToMany() {
        Clazz clazz = clazzMapper.getClazzOneToMany(1);
        log.info(String.valueOf(clazz.getClazzId()));
        log.info(clazz.getClazzName());
        // .forEach() 是 Java 8 引入的 Stream API 中的一个方法，用于对集合中的每个元素执行一个操作。
        clazz.getStudents().forEach(student -> log.info(String.valueOf(student)));
    }

    @Test
    void getClazz() {
        Clazz clazz = clazzMapper.getClazz(1);
        log.info("班级名称：{}", clazz.getClazzName());
        log.info("任课老师：{}", clazz.getTeacher().getTeacherName());
        log.info("班级学生信息如下：");
        clazz.getStudents().forEach(student -> log.info("{},{}", student.getStudentName(), student.getHometown()));
    }
}