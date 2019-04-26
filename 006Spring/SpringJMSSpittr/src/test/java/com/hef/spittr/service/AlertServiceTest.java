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
 * @Date 2019-04-25
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class AlertServiceTest {

    @Autowired
    private AlertService alertService;

    @Autowired
    public SpitterService spitterService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(alertService);
    }

    @Test
    public void sendMessage(){
        Spitter spitter = spitterService.getSpitter(1l);
        System.out.println(spitter);
        alertService.sendSpitterAlert(spitter);
    }

    @Test
    public void coverAndSendTest(){
        Spitter spitter = spitterService.getSpitter(1l);
        System.out.println(spitter);
        alertService.convertAndSend(spitter);
    }

    @Test
    public void sendTopicStr(){
        alertService.sendTopicMesage("hello topic");

    }

    @Test
    public void sendTopicSpitterMesage(){
        Spitter spitter = spitterService.getSpitter(1l);
        System.out.println(spitter);
        alertService.sendTopicSpitterMesage(spitter);
    }
}
