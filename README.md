> 本仓库是 Spring Boot 主要知识点的示例代码

模块说明：
- spring-boot-quickstart：起步模块
  - 练习1：多模块项目
  - 练习2：利用 Records 创建数据传输对象（DTO）
  - 练习3：结合 Switch Expressions 实现高级路由逻辑
  - 练习4：使用 LocalDate 和 LocalTime 处理日期和时间
  - 练习5：使用 Stream API 实现简单的用户过滤功能
  - Spring Boot 启动分析
  - IDEA环境下的热加载
- spring-boot-thymeleaf：模板引擎模块
  - 使用日志进行调试
  - 断点调试示例代码
  - 断点调试练习
  - 配置热更新
  - 远程调试
  - DevTools 的其他高级功能
    - 禁用特定开发环境功能
    - 监听文件的更改
    - 示例：完整的 application.yml 配置
  - 模板引擎 Thymeleaf
  - 待办清单练习
- spring-boot-logging：日志模块
  - logback日志框架配置
    - application 配置文件实现日志配置
    - 使用 logback-spring.xml 实现日志配置
- spring-boot-config：配置管理模块
  - YAML 语法及占位符语法
    - YAML 示例
    - 配置文件占位符
  - YAML 配置绑定变量两种方式
    - 使用 @Value 获取配置值
    - 使用 @ConfigurationProperties 获取配置值
  - 配置属性值数据绑定校验
    - 对绑定的属性值进行校验
    - 常用的校验注解
  - 较复杂的配置示例 
  - 加载额外配置文件
    - 加载 properties 配置文件
    - 加载 yaml 配置文件
      - 方式一：使用 spring.config.location 指定 YAML 文件
      - 方式二：YamlPropertySourceLoader 手动加载
    - 使用 @ImportResource 加载 Spring 的 XML 配置文件
  - 使用 SpEL 表达式绑定配置项
    - SpEL 结合 @Value 注解读取配置文件属性
    - SpEL 结合 @Value 注解读取系统环境变量
    - 读取 properties 文件中文乱码问题的解决
  - profile 不同环境使用不同配置
  - 配置文件的加载优先级
  - 综合练习
  - JWT 加密
  - OSS 文件上传
- Hutool 结合配置文件练习
  - 练习1：读取自定义配置文件并生成二维码
  - 练习2：自动读取配置文件生成日志
  - 练习3：自动备份配置文件
  - 练习4：读取文件内容并发送邮件
- 数据库
  1. 整合 Spring Data JPA
  2. 整合 Mybatis  
     2.1 一对一：教师和班级  
     2.2 一对多：班级和学生  
     2.3 多对一：学生和班级   
     2.4 综合练习  
         2.4.1 查询班级信息  
         2.4.2 查询学生信息
         2.4.3 查询课程信息
  3. 整合 Mybatis Plus  
     3.1 一对一：教师和班级  
     3.2 多对多：学生和课程
- spring-boot-exception: 异常处理模块  
  1. 自定义异常和相关数据结构
  2. 通用全局异常处理逻辑
  3. Spring Validation 数据校验
  4. 自定义校验注解
- spring-boot-task: 定时任务模块
  1. 使用 Timer 实现定时任务  
     1.1 定时发送提醒消息  
     1.2 实现简易倒计时器  
     1.3 模拟股票价格实时更新  
  2. 使用 @Scheduled 实现定时任务  
     2.1 实现定时任务  
     2.2 解决定时任务单线程运行的问题
  3. 定时任务案例  
     3.1 定时发送股票价格并持久化  
     3.2 每日发送邮件报表任务
  4. Quartz 实现定时任务
  5. Quartz 动态定时任务（数据库持久化）
- spring-boot-filter-interceptor: 过滤器和拦截器模块
  1. 过滤器  
     1.1 过滤器的基本用法  
         1.1.1 方法一：使用 @Bean 注册过滤器  
         1.1.2 方法二：使用 @WebFilter 注释  
     1.2 过滤器示例  
         1.2.1 日志记录过滤器  
         1.2.2 认证和授权过滤器