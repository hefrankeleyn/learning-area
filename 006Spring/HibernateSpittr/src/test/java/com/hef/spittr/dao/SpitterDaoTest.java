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
    private HibernateSpitterDao hibernateSpitterDao;

    @Test
    public void entiryShouldNotNull() {
        Assert.assertNotNull(hibernateSpitterDao);
    }

    @Test
    public void testSaveSpitter(){
        Spitter spitter = new Spitter("xiaoming","word","password","word@gmail.com",true);
        hibernateSpitterDao.save(spitter);
        Assert.assertNotNull(spitter.getId());
    }

    @Test
    public void testFindOne(){
        Spitter spitter = hibernateSpitterDao.findOne(7);
        Assert.assertNotNull(spitter);
    }

    @Test
    public void testFindAll(){
        List<Spitter> all = hibernateSpitterDao.findAll();
        Assert.assertNotNull(all);
        for(Spitter spitter: all){
            System.out.println(spitter);
        }

    }

    @Test
    public void testCount(){
        long count = hibernateSpitterDao.count();
        System.out.println(count);
    }


    @Test
    public void testFindSpitterByFullName(){
        Spitter spitter = hibernateSpitterDao.findByFullname("das");
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
    }


}
