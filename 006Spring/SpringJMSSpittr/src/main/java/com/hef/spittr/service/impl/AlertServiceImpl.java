package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;


/**
 * 使用Template操作Jms
 * @Date 2019-04-25
 * @Author lifei
 */
@Component
public class AlertServiceImpl implements AlertService {

    @Autowired
    private JmsOperations jmsOperations;

    @Override
    public void sendSpitterAlert(Spitter spitter) {
        jmsOperations.send("spitter.alert.queue", (session)->{
            return session.createObjectMessage(spitter);
        });
    }

    @Override
    public void convertAndSend(Spitter spitter) {
        jmsOperations.convertAndSend(spitter);
    }

    @Override
    public void sendTopicMesage(String message) {
        jmsOperations.send("spitter.topic",session -> {
            return session.createObjectMessage(message);
        });
    }

    @Override
    public void sendTopicSpitterMesage(Spitter message) {
        jmsOperations.convertAndSend("spitter.topic",message);
//        jmsOperations.send("spitter.topic",session -> {return session.createObjectMessage(message);});
    }
}
