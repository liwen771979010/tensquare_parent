package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
	//推荐职位
    List<Recruit> findByStateOrderByCreatetimeDesc(String state);// where state = ? order by createTime desc;

    //最新职位
    List<Recruit> findByStateNotOrderByCreatetimeDesc(String state);//where state != ? order by createTime desc;;
}
