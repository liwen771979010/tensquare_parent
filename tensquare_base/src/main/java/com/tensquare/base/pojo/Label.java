package com.tensquare.base.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * author: liwen
 * createTime:2019/9/12
 * 说明:  标签实体类
 */
@Entity
@Table(name = "tb_label")
@Data
@ToString
public class Label implements Serializable{
    @Id
    private String id;
    //标签名称
    private String labelname;
    //状态
    private String state;
    //使用数量
    private Long count;
    //关注数
    private Long fans;
    //是否推荐
    private String recommend;

}
