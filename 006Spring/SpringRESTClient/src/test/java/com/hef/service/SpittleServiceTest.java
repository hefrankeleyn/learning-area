package com.hef.service;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpittleService;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2019-04-22
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpittleServiceTest {

    @Autowired
    public SpittleService spittleService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spittleService);
    }

    @Test
    public void fetchSpitterByIdTest(){
        Spitter spitter = spittleService.fetchSpitterById(1l);
        System.out.println(spitter);
    }

    @Test
    public void findSpitterByIdTest(){
        Spitter spitter = spittleService.findSpitterById(1l);
        System.out.println(spitter);
    }

    @Test
    public void getSpitterByIdTest(){
        Spitter spitter = spittleService.getSpitterById(1l);
        System.out.println(spitter);
    }
}
