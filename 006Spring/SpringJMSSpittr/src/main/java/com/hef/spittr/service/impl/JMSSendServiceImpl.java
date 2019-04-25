package com.hef.spittr.service.impl;

import com.hef.spittr.service.JMSSendService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @Date 2019-04-24
 * @Author lifei
 */
@Component
public class JMSSendServiceImpl implements JMSSendService {

    @Override
    public void sendMessage(String message) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try (Connection connection  = connectionFactory.createConnection();
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
        ) {
            Destination destination = new ActiveMQQueue("spitter.queue");
            MessageProducer producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);
            producer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
