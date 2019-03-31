package com.hef.spittr.dao;


import com.hef.spittr.entities.Spittler;
import com.hef.spittr.service.SpittlerService;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles(value = {"dev"})
public class DaoTest {

    @Autowired
    private SpittlerDao spittlerDao;

    @Autowired
    private SpittlerService spittlerService;

    @Test
    public void testJndiDao(){
        Assert.assertNotNull(spittlerDao);
        Assert.assertNotNull(spittlerService);
    }

    @Test
    public void testConnection(){
        spittlerService.getConnection();
    }

    @Test
    public void testAddSpitter(){
        Spittler spittler = new Spittler();
        spittler.setUsername("aa");
        spittler.setPassword("password");
        spittler.setFullname("xiaoMing");
        spittler.setEmail("xiaoming@gmail.com");
        spittler.setUpdateByEmail(false);
        spittlerService.addSpittler(spittler);
    }


    @Test
    public void testUpdateSpitter(){
        Spittler spittler = new Spittler();
        spittler.setUsername("abc");
        spittler.setPassword("password");
        spittler.setFullname("xiaoMing");
        spittler.setEmail("abc@gmail.com");
        spittler.setUpdateByEmail(true);
        spittlerService.updateSpittler(spittler);
    }

    @Test
    public void testFindOneSpitter(){
        Spittler  spittler = spittlerService.findOneSpittler("xiaoMing");
        System.out.println(spittler);
        Assert.assertNotNull(spittler);
    }

}
