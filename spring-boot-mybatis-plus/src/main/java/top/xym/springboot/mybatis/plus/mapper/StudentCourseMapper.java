package top.xym.springboot.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.xym.springboot.mybatis.plus.entity.Course;
import top.xym.springboot.mybatis.plus.entity.StudentCourse;

import java.util.List;

@Mapper
public interface StudentCourseMapper extends BaseMapper<StudentCourse>{
    @Select("SELECT c.* FROM course c INNER JOIN student_course sc ON c.id = sc.course_id WHERE sc.student_id = #{studentId}")

    List<Course> selectCoursesByStudentId(Long studentId);
}
