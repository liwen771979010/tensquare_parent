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
@RabbitListener(queues = "itcast")
public class Customer1 {
    @RabbitHandler
    public void shouMessage(String mes){
        System.out.println("itcast消费者:--" + mes);
    }

}
