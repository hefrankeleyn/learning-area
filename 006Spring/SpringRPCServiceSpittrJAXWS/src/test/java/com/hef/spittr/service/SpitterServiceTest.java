package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;
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
public class SpitterServiceTest {
    @Autowired
    private SpitterService spitterService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterService);
    }

    // @Test
    public void saveSpitterTest(){
        Spitter spitter = new Spitter("remote procedure call", "rpc",
                "password","rpc@Gmail.com",false);
        Spitter s = spitterService.saveSpitter(spitter);
        System.out.println(s);
        Assert.assertNotNull(s.getId());
    }

    @Test
    public void testfinSpitterById(){
        Spitter spitter = spitterService.getSpitter(28L);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
    }

    @Test
    public void testFindAll(){
        List<Spitter> all = spitterService.getAllSpitters();
        for (Spitter sp :
                all) {
            System.out.println(sp);
        }
    }
}
