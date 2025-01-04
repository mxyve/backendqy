package top.xym.springboot.mybatis.plus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.xym.springboot.mybatis.plus.entity.Course;
import top.xym.springboot.mybatis.plus.entity.Student;
import top.xym.springboot.mybatis.plus.mapper.StudentCourseMapper;
import top.xym.springboot.mybatis.plus.mapper.StudentMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentCourseMapper studentCourseMapper;
    /**
     * 根据学生ID获取该学生的课程信息
     */
    public Student getStudentWithCourses(Long studentId) {
        Student student = studentMapper.selectById(studentId);
        if (student != null) {
            List<Course> courses = studentCourseMapper.selectCoursesByStudentId(studentId);
            student.setCourses(courses);
        }
        return student;
    }
}
