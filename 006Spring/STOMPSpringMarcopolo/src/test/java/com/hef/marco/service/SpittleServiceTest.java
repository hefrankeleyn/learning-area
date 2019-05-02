package com.hef.marco.service;

import com.hef.marco.domain.Spittle;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {RootConfig.class})
public class SpittleServiceTest {

    //@Autowired
    private SpittleService spittleService;

    //@Test
    public void shouldNotNull(){
        Assert.assertNotNull(spittleService);
    }

    //@Test
    public void findAllSpittleTest(){
        List<Spittle> spittles = spittleService.findAllSpittle();
        for (Spittle spittle :
                spittles) {
            System.out.println(spittle);
        }
    }

    //@Test
    public void findSpittleById(){
        Spittle spittle = spittleService.findSpittleById(7l);
        System.out.println(spittle);
    }

    //@Test
    public void saveSpittleTest(){
        Spittle spittle = new Spittle(2l, "world", new Date(),23.3, 26.5);
        Spittle save = spittleService.saveSpittle(spittle);
        System.out.println(save);
    }
}
