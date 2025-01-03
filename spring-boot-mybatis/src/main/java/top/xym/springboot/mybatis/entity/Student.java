package top.xym.springboot.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Integer studentId;
    private Integer clazzId;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
    // 多对一：学生和班级 多方里声明一方的对象
    private Clazz clazz;
    // 多对多：学生和课程 多方里声明一方的对象
    private List<Course> courses;
}
