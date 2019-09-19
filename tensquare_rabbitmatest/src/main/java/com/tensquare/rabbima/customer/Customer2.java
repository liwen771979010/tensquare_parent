package com.tensquare.rabbima.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * author: liwen
 * createTime:2019/9/18
 * 说明:
 */
@Component
@RabbitListener(queues = "emal")
public class Customer2 {
    @RabbitHandler
    public void shouMessage(String mes){
        System.out.println("emal消费者:--" + mes);
    }

}
