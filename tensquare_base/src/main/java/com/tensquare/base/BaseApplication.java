package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import util.IdWorker;

/**
 * author: liwen
 * createTime:2019/9/12
 * 说明:
 */
@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
        System.out.println("基础服务启动:9001--------------------------------------");
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}


