package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.AlertService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
@Component
public class AlertServiceImpl implements AlertService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param spitter
     */
    @Override
    public void sendSpitter(Spitter spitter) {
        rabbitTemplate.convertAndSend("spitter.alert.exchange", "direct.spitter", spitter);
    }

    @Override
    public void sendMessage(String message) {
        Message helloMessage = new Message(message.getBytes(), new MessageProperties());
        rabbitTemplate.send("spitter.fanout", "message", helloMessage);
    }
}
