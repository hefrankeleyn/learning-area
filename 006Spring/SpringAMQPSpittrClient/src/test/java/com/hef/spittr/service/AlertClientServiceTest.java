package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class AlertClientServiceTest {

    @Autowired
    private AlertClientService alertClientService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(alertClientService);
    }

    @Test
    public void receiveMessageTest(){
        String s = alertClientService.receiveMessage();
        System.out.println(s);
    }

    @Test
    public void receiveSpitter(){
        Spitter spitter = alertClientService.receiveSpitter();
        System.out.println(spitter);
    }
}
