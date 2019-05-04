package com.hef.spittr;

import config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @Date 2019-05-04
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ProxyTest {
    @Test
    public void loopWhileTest(){
        while (true){
            try {
                Thread.sleep(3000l);
                System.out.println("i have a dream");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
