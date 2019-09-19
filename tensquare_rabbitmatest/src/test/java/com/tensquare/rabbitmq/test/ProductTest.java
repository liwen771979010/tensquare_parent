package com.tensquare.rabbitmq.test;

import com.tensquare.rabbima.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: liwen
 * createTime:2019/9/18
 * 说明:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessge(){
        rabbitTemplate.convertAndSend("itcast","直连模式测试成功!");
    }

    @Test
    public void sendMessge2(){
        rabbitTemplate.convertAndSend("sq","","发布订阅模式测试");
    }

    /**
     * tpoic模式
     */
    @Test
    public void sendMessge3(){
        rabbitTemplate.convertAndSend("topic_test","info.mobile.5","手机用户");
    }
}
