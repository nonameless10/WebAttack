package com.cs.demo.controller;

import com.cs.demo.entity.Article;
import com.cs.demo.mapper.XssMapper;
import com.cs.demo.utils.JsoupUtil;
import com.cs.demo.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class XssController {

    @Resource
    XssMapper xssMapper;

    @PostMapping("/insertArticle")
    Result insertArticle(@RequestParam(value = "article") String article) {

        Result res;
    //    article = JsoupUtil.clean(article);
        Article myArticle = new Article(article);
        xssMapper.insertArticle(myArticle);
        if(myArticle.getArticleId() > 0) {
            res = new Result(1, "success", myArticle.getArticleId());
        } else {
            res = new Result(0, "failure", "发表文章失败");
        }
        return res;
    }

    @GetMapping("/queryArticleById/{id}")
    Result queryArticleById(@PathVariable("id") int id) {
        Result res;
        String article = xssMapper.queryArticleById(id);
        if(article != null) {
            res = new Result(1, "success", article);
        } else {
            res = new Result(0, "failure", "查询文章失败");
        }
        return res;
    }
}
