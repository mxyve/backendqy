package top.xym.springboot.redis.mapper;
// 定义根据手机号查询用户信息的方法并实
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.xym.springboot.redis.entity.User;

public interface UserMapper extends BaseMapper<User> {

    default User getByPhone(String phone){
        return this.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone, phone));
    }
}
