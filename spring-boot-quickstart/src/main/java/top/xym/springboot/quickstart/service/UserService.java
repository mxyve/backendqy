package top.xym.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.xym.springboot.quickstart.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final List<User> users= List.of(
            new User(1L, "张三", 22),
            new User(2L, "张三风", 17),
            new User(3L, "张三丰", 19),
            new User(4L, "张三峰", 25)
    );

    public List<String> getAdultUserNames() {
        return users.stream()
                // 过滤年龄大于18岁的用户
                .filter(user -> user.getAge() >18)
                // 提取名字
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
