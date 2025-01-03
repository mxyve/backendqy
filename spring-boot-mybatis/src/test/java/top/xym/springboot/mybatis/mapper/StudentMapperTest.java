package top.xym.springboot.mybatis.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.springboot.mybatis.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void insert() {
        Student student = Student.builder().clazzId(1).studentName("测试学生")
                .hometown("广东").birthday(LocalDate.now()).build();
        int n = studentMapper.insert(student);
//        这是一个 JUnit 测试框架的断言语句，用于检查 insert 操作是否成功。
//        这里期望 n 的值为 1，即期望插入操作成功插入了一条记录。
        assertEquals(1, n);
    }

    @Test
    void findStudentById() {
        Student student = studentMapper.findStudentById(1001);
        assertEquals("钱智康", student.getStudentName());
    }

    @Test
    void updateById() {
        Student student= Student.builder().studentId(1001).studentName("新的名字").build();
        int n = studentMapper.updateById(student);
        assertEquals(1, n);
    }

    @Test
    void deleteById() {
        int n = studentMapper.deleteById(8017);
        assertEquals(1, n);
    }

    @Test
    void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(8000 + i)
                    .clazzId(1)
                    .studentName("测试学生" + i)
                    .hometown("南京")
                    .birthday(LocalDate.now())
                    .build();
            students.add(student);
        }
        int n = studentMapper.batchInsert(students);
        assertEquals(10, n);
    }

    @Test
    void batchDelete() {
        List<Integer> idList = List.of(8003, 8004, 8005);
        int n = studentMapper.batchDelete(idList);
        assertEquals(3, n);
    }

    @Test
    void batchByDynamicSql() {
        Student student = Student.builder().hometown("州").build();
        List<Student> students = studentMapper.selectByDynamicSql(student);
        students.forEach(System.out::println);
    }
}