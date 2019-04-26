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
public class AlterreceiveServiceTest {

    @Autowired
    private AlterReceiveService alterReceiveService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(alterReceiveService);
    }

    /**
     * recevie topic
     */
    @Test
    public void receiveSpitterTest(){
        Spitter spitter = alterReceiveService.receiveSpitterAlter();
        System.out.println(spitter);

    }

    @Test
    public void receiveTest(){
        Spitter spitter = alterReceiveService.receveSpitter();
        System.out.println(spitter);
    }

    @Test
    public void receiveTopicStrTest(){
        String s = alterReceiveService.receiveTopicstrMessage();
        System.out.println(s);
    }

    @Test
    public void receiveTopicSpitterTest(){
        Spitter spitter = alterReceiveService.receiveTopicSpitter();
        System.out.println(spitter);
    }
}
