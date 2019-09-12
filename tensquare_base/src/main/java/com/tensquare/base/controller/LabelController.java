package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        labelService.findAll();
        return new Result(true,StatusCode.OK,"查询成功");
    }

    @RequestMapping(value = "/{labelId}")
    public Result findById(@PathVariable String labelId){
        labelService.findById(labelId);
        return new Result(true,StatusCode.OK,"查询成功");
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

}
