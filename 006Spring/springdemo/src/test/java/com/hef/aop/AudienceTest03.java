package com.hef.aop;

import com.hef.aop.aspect03.ConcertConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class AudienceTest03 {

    @Autowired
    private Performance performance;

    @Autowired
    private Performance failPerformance;

    @Test
    public void singPerformanceShouldNotNull(){
        assertNotNull(performance);
    }

    @Test
    public void failPerformanceShouldNotNull(){
        assertNotNull(failPerformance);
    }
    @Test
    public void performTest(){
        performance.perform();
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
