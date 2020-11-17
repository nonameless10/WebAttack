package com.cs.demo.mapper;


import com.cs.demo.entity.Article;
import org.apache.ibatis.annotations.*;

@Mapper
public interface XssMapper {

    @Select("select article from article where article_id = #{id}")
    String queryArticleById(int id);

    @Options(useGeneratedKeys = true, keyProperty = "articleId", keyColumn = "article_id")
    @Insert("insert into article(article) values(#{article.article})")
    void insertArticle(@Param("article") Article article);

}
