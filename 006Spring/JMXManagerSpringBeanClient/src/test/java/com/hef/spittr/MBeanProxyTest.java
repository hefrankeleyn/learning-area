package com.hef.spittr;

import com.hef.spittr.jmx.SpittleControllerManagedOperations;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {RootConfig.class})
public class MBeanProxyTest {

//    @Autowired
    private SpittleControllerManagedOperations spittleControllerManagedOperations;

//    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spittleControllerManagedOperations);
    }

//    @Test
    public void getSpittlesPerPageTest(){
        int spittlesPerPage = spittleControllerManagedOperations.getSpittlesPerPage();
        System.out.println("spittlesPerPage: " + spittlesPerPage);
    }

    //@Test
    public void setSpittlesPerPageTest(){
        spittleControllerManagedOperations.setSpittlesPerPage(6);
    }
}
