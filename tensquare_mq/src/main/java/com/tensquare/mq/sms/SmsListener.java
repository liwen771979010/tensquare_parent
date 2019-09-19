package com.tensquare.mq.sms;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.mq.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * author: liwen
 * createTime:2019/9/19
 * 说明:
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    @Autowired
    private SmsUtil smsUtil;

    @RabbitHandler
    public void sendSms(Map<String,String> map){
        String mobile = map.get("mobile");
        String checkCode = map.get("checkCode");
        System.out.println("消息已接受");
        System.out.println("手机号:"+ map.get("mobile"));
        System.out.println("验证码:"+ map.get("checkCode"));
        try {
            smsUtil.sendSms(mobile, "SMS_162198840", "李文", "{\"code\":\"" + checkCode + "\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
