package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * author: liwen
 * createTime:2019/9/15
 * 说明:
 */
public interface SpitDao extends MongoRepository<Spit,String> {
    Page findByParentid(String parentid, Pageable pageable);
}
