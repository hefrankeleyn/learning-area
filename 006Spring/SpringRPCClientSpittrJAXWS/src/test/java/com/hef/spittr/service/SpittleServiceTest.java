package com.hef.spittr.service;

import com.hef.spittr.jaxws.client.Spitter;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Date 2019-04-20
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpittleServiceTest {

    @Autowired
    private SpittleService spittleService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spittleService);
    }

    @Test
    public void findSpitterById(){
        Spitter spitter = spittleService.findSpitterById(2L);
        System.out.println(spitter);
    }
    @Test
    public void findAllSpitters(){
        List<Spitter> spitters = spittleService.getAllSpitter();
        for (Spitter sp :
                spitters) {
            System.out.println(sp);
        }
    }
}
