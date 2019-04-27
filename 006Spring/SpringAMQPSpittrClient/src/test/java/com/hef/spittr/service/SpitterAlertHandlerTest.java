package com.hef.spittr.service;

import config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterAlertHandlerTest {

    @Test
    public void waritHandlerTest(){
        System.out.println("begin wait: ");
        while (true){
            try {
                Thread.sleep(300l);
                System.out.println("welcome...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
