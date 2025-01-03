package top.xym.springboot.jpa.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.xym.springboot.jpa.entity.Article;
import top.xym.springboot.jpa.repository.ArticleRepository;
import top.xym.springboot.jpa.service.ArticleService;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    // 将JPA仓库对象注入
    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        // 保存一个对象到数据库
        articleRepository.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        // 根据id删除1条数据库记录
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        //更新一个对象到数据库，仍然使用 save 方法，实际是根据 article.id 去 update
        articleRepository.save(article);
    }

    @Override
    public Article getArticle(Long id) {
        // 根据id查询1条数据库记录
//        Optional 是 Java 8 引入的一个容器类，它可以包含一个对象（Article 对象）或者不包含对象（表示结果为空）。
//        使用 Optional 的好处是避免了 null 引用的问题，使得代码更加健壮和可读。
        Optional<Article> articleOptional = articleRepository.findById(id);
//        orElse(null) 是 Optional 类的一个方法。
        return articleOptional.orElse(null);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

}
