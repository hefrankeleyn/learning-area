package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterDaoTest {

    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterDao);
    }

    @Test
    public void findSpitterById(){
        Spitter spitter = spitterDao.findSpitterById(1L);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
    }



    @Test
    public void findAllSpitters(){
        List<Spitter> spitters = spitterDao.findAllSpitters();
        for (Spitter s:
             spitters) {
            System.out.println(s);
        }
        Assert.assertNotNull(spitters);
    }

    @Test
    public void saveSpitter(){
        Spitter s = new Spitter(
                "hefrankeleyn",
                "spittr",
                "spittr",
                "spittr@gmail.com",
                true);
        spitterDao.saveSpitter(s);

    }
}
