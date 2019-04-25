package com.hef.spittr.service;

import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2019-04-25
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class JMSReceiveServiceTest {

    @Autowired
    private JMSReceiveService jmsReceiveService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(jmsReceiveService);
    }

    @Test
    public void receiveMessageTest(){
        String message = jmsReceiveService.receiveMessage();
        System.out.println(message);
    }
}
