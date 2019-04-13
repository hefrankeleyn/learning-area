package com.hef.spittr;

import con.hef.spittr.domain.Spitter;
import con.hef.spittr.service.SpitterService;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void testFindOneSpitter(){
        Spitter spitter = spitterService.findSpitterById(1L);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
    }

    @Test
    public void testSaveSpitter(){
        Spitter spitter = new Spitter("apple", "applePhone",
                "password","apple@Gmail.com",false);
        Spitter sp = spitterService.saveSpitter(spitter);
        System.out.println(sp);
        Assert.assertNotNull(sp.getId());
    }

    @Test
    public void testDeleteSpitter(){
        spitterService.deleteSpitter(20L);
    }
}
