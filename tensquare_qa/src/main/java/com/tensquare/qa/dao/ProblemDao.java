package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    //最新回答列表
    @Query(value = "select *  FROM tb_problem,tb_pl WHERE id=problemid and labelid = ? order by replytime desc ",nativeQuery = true)
    Page<Problem> newList(String labelid, Pageable pageable);

    //热门回答列表
    @Query(value = "select *  FROM tb_problem,tb_pl WHERE id=problemid and labelid = ? order by reply desc ",nativeQuery = true)
    Page<Problem> hostList(String labelid, Pageable pageable);

    //等待回答列表
    @Query(value = "select *  FROM tb_problem,tb_pl WHERE id=problemid and labelid =? and reply = 0 ORDER BY createtime",nativeQuery = true)
    Page<Problem> waitList(String labelid, Pageable pageable);
}
