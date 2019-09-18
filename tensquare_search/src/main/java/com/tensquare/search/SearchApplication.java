package com.tensquare.search;

import com.sun.org.apache.bcel.internal.generic.I2B;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * author: liwen
 * createTime:2019/9/16
 * 说明:
 */
@SpringBootApplication
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class);
        System.out.println("搜索服务:9007---------------------------------");
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
