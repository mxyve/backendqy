package top.xym.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import top.xym.springboot.mybatis.entity.Student;

import java.util.List;

public interface StudentMapper {
    int insert(Student student);

    Student findStudentById(int studentId);

    int updateById(Student student);

    int deleteById(int studentId);

    int batchInsert(@Param("students") List<Student> students);

    int batchDelete(@Param("idList") List<Integer> ids);

    int batchUpdate(@Param("students") List<Student> students);

    List<Student> selectByDynamicSql(Student student);

    /**
     * 根据学生id查询（关联查询所属班级信息）
     * @param studentId 学生id
     * @return 学生信息
     */
    Student getStudentManyToOne(int studentId);

}
