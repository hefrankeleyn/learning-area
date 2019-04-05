package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles("dev")
public class SpitterDaoTest {

    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterDao);
    }

    @Test
    public void findAllSpitter(){
        List<Spitter> spitters = spitterDao.findAll();
        for (Spitter spitter: spitters){
            System.out.println(spitter);
        }
        Assert.assertNotNull(spitters);
    }

    @Test
    public void saveSpitter(){
        Spitter spitter = new Spitter();
        spitter.setFullName("spitter");
        spitter.setUsername("username");
        spitter.setPassword("password");
        spitter.setEmail("username@gmail.com");
        spitter.setUpdateByEmail(false);
        spitterDao.save(spitter);
    }

    @Test
    public void testFindSpitterByUsername(){
        Spitter spitter = spitterDao.findByUsername("username");
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
    }

    @Test
    public void testFindAllGmailSpitters(){
        List<Spitter> spitters = spitterDao.findAllGmailSpitters();
        for (Spitter s: spitters) {
            System.out.println(s);
        }
    }

    @Test
    public void testUpdateFullNameByCondition(){
        int i = spitterDao.updateFullNameByCondition();
        System.out.println(i);
    }
}
