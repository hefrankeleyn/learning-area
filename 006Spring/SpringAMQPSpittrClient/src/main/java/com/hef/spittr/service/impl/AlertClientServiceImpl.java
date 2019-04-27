package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.AlertClientService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
@Component
public class AlertClientServiceImpl implements AlertClientService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String receiveMessage() {
        Message message = rabbitTemplate.receive("spitter.alert.queue.2");
        byte[] body = message.getBody();
        return new String(body);
    }

    @Override
    public Spitter receiveSpitter() {
        return (Spitter) rabbitTemplate.receiveAndConvert("spitter.alerts");
    }
}
