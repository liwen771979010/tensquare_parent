package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

/**
 * author: liwen
 * createTime:2019/9/16
 * 说明:
 */
@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleSearchDao articleSearchDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 增加文章
     * @param article
     */
    public void add(Article article){
        //article.setId(idWorker.nextId()+"");
        articleSearchDao.save(article);
    }

    /**
     * 查询
     * @param keys
     * @param page
     * @param size
     * @return
     */
    public Page<Article> findByKeys(String keys, int page, int size){
        Pageable pageable = PageRequest.of(page-1,size);
        return articleSearchDao.findByTitleOrContentLike(keys, keys, pageable);

    }
}
