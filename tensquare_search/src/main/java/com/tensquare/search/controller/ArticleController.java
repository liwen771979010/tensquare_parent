package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * author: liwen
 * createTime:2019/9/16
 * 说明:
 */
@RequestMapping(value = "/article")
@RestController
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 保存
     * @param article
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleService.add(article);
        return new Result(true,StatusCode.OK,"操作成功");
    }

    /**
     * 模糊查询
     * @param keys
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{keys}/{page}/{size}", method = RequestMethod.GET)
    public Result findKeys(@PathVariable String keys, @PathVariable int page, @PathVariable int size){
        Page<Article> pageData = articleService.findByKeys(keys, page, size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Article>(pageData.getTotalElements(),pageData.getContent()));
    }

}
