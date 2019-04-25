package com.hef.spittr.service.impl;

import com.hef.spittr.service.JMSReceiveService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @Date 2019-04-25
 * @Author lifei
 */
@Component
public class JMSReceiveServiceImpl implements JMSReceiveService {
    @Override
    public String receiveMessage() {
        String result = null;
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try (Connection con = cf.createConnection();

        ){
            con.start();
            try(Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE)){
                Destination destination = new ActiveMQQueue("spitter.queue");
                MessageConsumer consumer = session.createConsumer(destination);
                Message message = consumer.receive();
                TextMessage textMessage = (TextMessage)message;
                result= textMessage.getText();
            }
            con.start();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
