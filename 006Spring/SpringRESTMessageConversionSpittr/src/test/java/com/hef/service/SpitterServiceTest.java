package com.hef.service;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterService;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Date 2019-04-22
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterServiceTest {

    @Autowired
    private SpitterService spitterService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterService);
    }

    @Test
    public void findSpitterById(){
        Spitter spitter = spitterService.findSpitterById(20l);
        System.out.println(spitter);
    }

    @Test
    public void findAllSpitters(){
        List<Spitter> spitters = spitterService.getAllSpitters();
        for (Spitter spitter :
                spitters) {
            System.out.println(spitter);
        }
    }
    @Test
    public void updateSpitter(){
        Spitter spitter = spitterService.getSpitter(1l);
        System.out.println(spitter);

//        spitter.setFullName("PUT resources");
//        Spitter update = spitterService.updateSpitter(spitter);
//        System.out.println(update);
    }

    @Test
    public void deleteSpitterTest(){
        Spitter spitter = spitterService.findSpitterById(33L);
        System.out.println(spitter);
        Assert.assertNull(spitter);
//        Assert.assertNotNull(spitter);

        /*spitterService.deleteSpitterById(33l);

        Spitter oldSpitter = spitterService.findSpitterById(33l);
        Assert.assertNull(oldSpitter);*/
    }



}
