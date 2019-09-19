package com.tensquare.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: liwen
 * createTime:2019/9/19
 * 说明:
 */
@SpringBootApplication
public class MqApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class);
        System.out.println("MQ服务启动:9009--");
    }
}
