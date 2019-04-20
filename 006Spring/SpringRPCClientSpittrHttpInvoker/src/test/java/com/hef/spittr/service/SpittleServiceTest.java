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
public class SpittleServiceTest {

    @Autowired
    private SpittleService spittleService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spittleService);
    }

    @Test
    public void testFindSpitterById(){
        Spitter spitter = spittleService.findSpitterById(1L);
        System.out.println(spitter);
    }

    @Test
    public void testFindAllSpitter(){
        List<Spitter> all = spittleService.getAllSpitter();
        for (Spitter sp:
                all) {
            System.out.println(sp);
        }
        Assert.assertNotNull(all);
    }

    @Test
    public void testSaveSpitter(){
        Spitter spitter = new Spitter("rpc client", "client",
                "password","client@Gmail.com",true);
        Spitter save = spittleService.saveSpitter(spitter);
        System.out.println(save);
        Assert.assertNotNull(save.getId());

    }

    @Test
    public void testInterfaceName(){
        System.out.println(SpitterService.class.getSimpleName());
    }
}
