package top.xym.springboot.configuration.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.xym.springboot.configuration.entity.Special;

import java.util.List;

@Mapper
public interface SpecialMapper {
    @Select("SELECT * FROM List ORDER BY updated DESC")
    List<Special> findAll();
}
