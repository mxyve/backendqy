package top.xym.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.xym.springboot.jpa.entity.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    // 关键字查询接口 自定义
    //注意这个方法的名称，jpa 会根据方法名自动生成 SQL 执行
    Article findByTitle(String author);
}
