package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterDaoTest {

    @Autowired
    private JpaSpitterDao jpaSpitterDao;


    @Test
    public void testShouldNotNull(){
        Assert.assertNotNull(jpaSpitterDao);
    }


    @Test
    public void testSaveSpittr(){
        Spitter spitter =
                new Spitter();
        spitter.setFullName("daMing");
        spitter.setUsername("xiao");
        spitter.setPassword("world");
        spitter.setEmail("aaa@gmail.com");
        spitter.setUpdateByEmail(true);
        jpaSpitterDao.saveSpitter(spitter);
    }
}
