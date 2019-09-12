package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

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


}
