package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import config.ContainerRootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContainerRootConfig.class})
@ActiveProfiles("pro")
public class ContainerSpitterDaoTest {

    @Autowired
    private ContainerJpaSpitterDao containerJpaSpitterDao;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(containerJpaSpitterDao);
    }

    @Test
    public void testSaveSpitter(){
        Spitter spitter =
                new Spitter();
        spitter.setFullName("xiaoHong");
        spitter.setUsername("hong");
        spitter.setPassword("world");
        spitter.setEmail("xiaohong@gmail.com");
        spitter.setUpdateByEmail(true);
        containerJpaSpitterDao.saveSpitter(spitter);
    }

    @Test
    public void testAddSpitter(){
        Spitter spitter =
                new Spitter();
        spitter.setFullName("xiaoHong");
        spitter.setUsername("hong");
        spitter.setPassword("world");
        spitter.setEmail("xiaohong@gmail.com");
        spitter.setUpdateByEmail(true);
        containerJpaSpitterDao.addSpitter(spitter);
    }

    @Test
    public void testGetSpitterById(){
        Spitter spitter = containerJpaSpitterDao.getSpitterById(9);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
    }


}
