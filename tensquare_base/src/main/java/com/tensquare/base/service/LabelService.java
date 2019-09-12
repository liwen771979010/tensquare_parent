package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.ec.CurveDB;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * author: liwen
 * createTime:2019/9/12
 * 说明: 标签service
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据id查询
     * @param labelId
     * @return
     */
    public Label findById(String labelId){
        return labelDao.findById(labelId).get();
    }

    /**
     * 添加标签
     * @param label
     */
    public void save(Label label){
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 修改
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }

    /**
     * 根据id删除
     * @param labelId
     */
    public void deleteById(String labelId){
        labelDao.deleteById(labelId);
    }


    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root : 根对象,就是把条件封装到那个对象中
             * @param query: 查询的关键字
             * @param cb: 封装条件对象
             * @return: 如果直接返回null,表示不需要任何条件
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(StringUtils.isNotBlank(label.getLabelname())){
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if(StringUtils.isNotBlank(label.getState())){
                    Predicate predicate =cb.equal(root.get("state").as(String.class),label.getState());
                    list.add(predicate);
                }
                if(StringUtils.isNotBlank(label.getRecommend())){
                    Predicate predicate = cb.equal(root.get("recommend").as(String.class),label.getRecommend());
                    list.add(predicate);
                }
                Predicate[] predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);

                return cb.and(predicates);
            }
        });
    }

    public Page<Label> pageQuery(Label label, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root : 根对象,就是把条件封装到那个对象中
             * @param query: 查询的关键字
             * @param cb: 封装条件对象
             * @return: 如果直接返回null,表示不需要任何条件
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(StringUtils.isNotBlank(label.getLabelname())){
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if(StringUtils.isNotBlank(label.getState())){
                    Predicate predicate =cb.equal(root.get("state").as(String.class),label.getState());
                    list.add(predicate);
                }
                if(StringUtils.isNotBlank(label.getRecommend())){
                    Predicate predicate = cb.equal(root.get("recommend").as(String.class),label.getRecommend());
                    list.add(predicate);
                }
                Predicate[] predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);

                return cb.and(predicates);
            }
        },pageable);
    }
}
