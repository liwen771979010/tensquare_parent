package com.tensquare.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        System.out.println("用户服务启动:9008-------------------");
    }

    @Bean
    public IdWorker idWorkker() {
        return new IdWorker(1, 1);
    }

}
