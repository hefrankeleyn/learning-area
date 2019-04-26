package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.AlterReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * @Date 2019-04-25
 * @Author lifei
 */
@Component
public class AlterReceiveServiceImpl implements AlterReceiveService {

    @Autowired
    private JmsOperations jmsOperations;
    @Override
    public Spitter receiveSpitterAlter() {
//        ObjectMessage objectMessage = (ObjectMessage) jmsOperations.receive();
//        try {
//            Spitter spitter = (Spitter) objectMessage.getObject();
//            return spitter;
//        } catch (JMSException e) {
//            throw JmsUtils.convertJmsAccessException(e);
//        }
        return (Spitter) jmsOperations.receiveAndConvert();
    }

    @Override
    public Spitter receveSpitter() {
        ObjectMessage objectMessage = (ObjectMessage) jmsOperations.receive("spitter.alert.queue");
        try {
            Spitter spitter = (Spitter) objectMessage.getObject();
            return spitter;
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
    }

    @Override
    public String receiveTopicstrMessage() {
        ObjectMessage objectMessage = (ObjectMessage) jmsOperations.receive("spitter.topic");
        try {
            return (String) objectMessage.getObject();
        } catch (JMSException e) {
            throw  JmsUtils.convertJmsAccessException(e);
        }

    }

    @Override
    public Spitter receiveTopicSpitter() {
        /*ObjectMessage objectMessage = (ObjectMessage) jmsOperations.receive("spitter.topic");
        try {
            return (Spitter) objectMessage.getObject();
        } catch (JMSException e) {
            throw  JmsUtils.convertJmsAccessException(e);
        }*/
        return (Spitter) jmsOperations.receiveAndConvert("spitter.topic");
    }
}
