package com.cs.demo.mapper;

import com.cs.demo.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class XssMapperTest {

    @Resource
    XssMapper xssMapper;

    @Test
    void queryArticleById() {
        String article = xssMapper.queryArticleById(1);
        System.out.println(article);
    }

    @Test
    void insertArticle() {
        Article article = new Article("作者还是cs");
        xssMapper.insertArticle(article);
        System.out.println(article.getArticleId());
    }
}