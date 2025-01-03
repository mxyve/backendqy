package top.xym.springboot.mybatis.mapper;

import top.xym.springboot.mybatis.entity.Clazz;

public interface ClazzMapper {
    /**
     * 根据班级id查询班级信息
     *
     * @param clazzId 班级id
     * @return 班级信息
     */
    Clazz getClazzOneToMany(int clazzId);
}
