package com.tensquare.base.controller;

import com.sun.deploy.xml.XMLable;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: liwen
 * createTime:2019/9/12
 * 说明:
 */
@RestController
@CrossOrigin    //可实现跨域
@RequestMapping(value = "/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Label> list = labelService.findAll();
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value = "/{labelId}")
    public Result findById(@PathVariable String labelId){
        Label label = labelService.findById(labelId);
        return new Result(true,StatusCode.OK,"查询成功",label);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result updata(@PathVariable("labelId") String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 根据条件查询
     * @param label
     * @return
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        List<Label> list = labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"条件查询成功",list);
    }

    /**
     * 条件,分页查询
     * @param page
     * @param size
     * @param label
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result pageQuery(@PathVariable Integer page, @PathVariable Integer size, @RequestBody Label label){
        if(page==null || ("").equals(page)){
            page = 1;
        }
        if(size==null || ("").equals(size)){
            size = 10;
        }
        Page<Label> pageData = labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"条件分页查询成功!",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }

}
