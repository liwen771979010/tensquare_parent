package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: liwen
 * createTime:2019/9/15
 * 说明:
 */
@RestController
@RequestMapping(value = "/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询吐槽全部列表
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result findAll(){
        List<Spit> list = spitService.findAll();
        return new Result(true,StatusCode.OK,"吐槽列表查询成功",list);
    }

    /**
     * 根据id查询吐槽
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findOne(@PathVariable String id){
        Spit spit = spitService.findById(id);
        return new Result(true,StatusCode.OK,"根据id查询吐槽成功!",spit);
    }

    /**
     * 吐槽添加
     * @param spit
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit){
        spitService.save(spit);
        return new Result(true,StatusCode.OK,"吐槽添加成功!");
    }

    /**
     * 吐槽修改
     * @param spit
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Spit spit, @PathVariable String id){
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"吐槽修改成功!");
    }

    /**
     * 删除吐槽
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        spitService.deleteById(id);
        return new Result(true,StatusCode.OK,"吐槽删除成功!");
    }

    /**
     * 根据父id查询列表,分页
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result findByParentid(@PathVariable String parentid, @PathVariable Integer page, @PathVariable Integer size){
        Page<Spit> pageData = spitService.findByParentid(parentid, page, size);
        return new Result(true,StatusCode.OK, "查询成功",new PageResult<Spit>(pageData.getTotalElements(),pageData.getContent()));
    }

    /**
     * 点赞
     * @param spitId
     * @return
     */
    @RequestMapping(value = "/thumbup/{spitId}", method = RequestMethod.PUT)
    public Result addThumbup(@PathVariable String spitId){
        //先判断是否已经点过赞
        String userid = "liwne";
       if(redisTemplate.opsForValue().get("thumbup_"+userid)!=null){
           return new Result(false, StatusCode.REPERROR,"不能重复点赞");
       }
       redisTemplate.opsForValue().set("thumbup_"+userid,1);
        spitService.addThumbup(spitId);
        return new Result(true,StatusCode.OK,"点赞成功");
    }

}
