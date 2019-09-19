package com.tensquare.rabbima;

import org.springframework.amqp.rabbit.core.RabbitManagementTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: liwen
 * createTime:2019/9/18
 * 说明:
 */
@SpringBootApplication
public class RabbitmqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class);
        System.out.println("启动成功-------------------------------------------");
    }
}
