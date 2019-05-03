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
 * @Date 2019-05-03
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterEmailServiceTest {

    @Autowired
    private SpitterEmailService spitterEmailService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterEmailService);
    }

    @Test
    public void sendEmailTest(){
        Spitter spitter = new Spitter("Xiao xi", "xiao", "password",
                "hefrankeleyn@gmail.com", true);
        spitterEmailService.sendSimpleSpittleEmail(spitter);
    }
}
