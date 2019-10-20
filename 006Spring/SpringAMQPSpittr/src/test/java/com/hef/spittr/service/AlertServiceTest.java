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
public class AlertServiceTest {

    @Autowired
    private AlertService alertService;

    @Autowired
    private SpitterService spitterService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(alertService);
    }

    @Test
    public void sendMessageTest(){
        alertService.sendMessage("hello world");
    }

    @Test
    public void sendSpitterTest(){
        Spitter spitter = spitterService.getSpitter(1l);
        System.out.println(spitter);
        alertService.sendSpitter(spitter);
    }

    @Test
    public void sendHandlerTest(){
        Spitter spitter = null;
        spitter = spitterService.getSpitter(1l);
        System.out.println(spitter);
        alertService.sendHandlerSpitter(spitter);

        spitter = spitterService.getSpitter(2l);
        System.out.println(spitter);
        alertService.sendHandlerSpitter(spitter);
    }

}
