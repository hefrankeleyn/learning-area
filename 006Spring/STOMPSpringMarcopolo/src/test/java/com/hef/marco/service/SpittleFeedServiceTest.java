package com.hef.marco.service;

import com.hef.marco.domain.Spittle;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2019-05-02
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpittleFeedServiceTest {

    @Autowired
    private SpittleService spittleService;

    @Autowired
    private SpittleFeedService spittleFeedService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spittleFeedService);
        Assert.assertNotNull(spittleService);
    }

    @Test
    public void broadcastSpittleTest(){
        Spittle spittle = spittleService.findSpittleById(11l);
        System.out.println(spittle);
        spittleFeedService.broadcastSpittle(spittle);
    }
}
