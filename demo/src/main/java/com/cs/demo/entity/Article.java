package com.cs.demo.entity;

public class Article {

    private int articleId;
    private String article;

    public Article(String article) {
        this.article = article;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }


    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", article='" + article + '\'' +
                '}';
    }
}
