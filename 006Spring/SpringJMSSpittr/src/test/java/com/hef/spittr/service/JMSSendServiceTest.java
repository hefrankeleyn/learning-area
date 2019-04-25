package com.hef.spittr.service;

import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2019-04-24
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class JMSSendServiceTest {

    @Autowired
    private JMSSendService jmsSendService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(jmsSendService);
    }

    @Test
    public void sendMessageTest(){
        jmsSendService.sendMessage("hello");
    }
}
