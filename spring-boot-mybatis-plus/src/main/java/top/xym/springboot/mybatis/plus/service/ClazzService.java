package top.xym.springboot.mybatis.plus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.xym.springboot.mybatis.plus.entity.Clazz;
import top.xym.springboot.mybatis.plus.entity.Teacher;
import top.xym.springboot.mybatis.plus.mapper.ClazzMapper;

@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;
    /**
     * 根据班级ID获取班级和对应老师
     */
    public Clazz getClazzWithTeacher(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }
}
