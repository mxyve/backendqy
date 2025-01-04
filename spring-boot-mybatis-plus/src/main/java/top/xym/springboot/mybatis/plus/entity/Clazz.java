package top.xym.springboot.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Clazz {
    private Long id;
    private String name;
    private Long teacherId;

    // 用于一对一映射
    @TableField(exist = false)
    private Teacher teacher;
}
