package com.hef.aop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/aop/aspect2/concert-config.xml")
public class AudienceTest02 {

    @Autowired
    private Performance singPerformance;

    @Autowired
    private Performance failPerformance;

    @Test
    public void singPerformanceShouldNotNull(){
        assertNotNull(singPerformance);
    }

    @Test
    public void failPerformanceShouldNotNull(){
        assertNotNull(failPerformance);
    }
    @Test
    public void performTest(){
        singPerformance.perform();
    }

    @Test
    public void failPerformTest(){
        try {
            failPerformance.perform();
        }catch (Exception e){
            System.out.println("These is a fail perform.");
        }
    }
}
