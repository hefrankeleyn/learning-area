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
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpittrDaoTest {

    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterDao);
    }

    @Test
    public void findOne(){
        Optional<Spitter> one = spitterDao.findById(1L);
        System.out.println(one.get());
        Assert.assertNotNull(one);
    }

    @Test
    public void findAll(){
        List<Spitter> all = spitterDao.findAll();
        for (Spitter sp:
             all) {
            System.out.println(sp);

        }
    }
}
