package top.xym.springboot.jpa.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.springboot.jpa.entity.Article;

import java.util.List;

@SpringBootTest
@Slf4j
class ArticleServiceTest {

    @Resource
    private ArticleService articleService;

    @Test
    void saveArticle() {
        Article article = Article
                .builder()
                .author("xym")
                .title("spring boot 学习")
                .content("spring boot 学习")
                .build();
        articleService.saveArticle(article);
    }

    @Test
    void updateArticle() {
        Article article = Article
                .builder()
                .id(10L)
                .author("Java 工程师")
                .title("spring boot 学习最新版")
                .content("spring boot 学习最新版")
                .build();
        articleService.updateArticle(article);
    }

    @Test
    void getArticle() {
        Article article = articleService.getArticle(1L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
        List<Article> all = articleService.getAll();
        all.forEach(article -> log.info(String.valueOf(article)));
    }

    @Test
    void deleteArticle() {
        articleService.deleteArticle(1L);
    }
}