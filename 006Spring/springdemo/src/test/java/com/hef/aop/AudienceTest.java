package com.hef.aop;


import static org.junit.Assert.*;

import com.hef.aop.aspect01.ConcertConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class AudienceTest {

    @Autowired
    private Performance performance;

    @Autowired
    private Performance failePerformance;
    @Test
    public void performanceShouldNotNull(){
        assertNotNull(performance);
    }

    @Test
    public void failPerformanceShouldNotNull(){
        assertNotNull(failePerformance);
    }

    @Test
    public void performTest(){
        performance.perform();
    }

    @Test
    public void failPerformTest(){
        try {
            failePerformance.perform();
        }catch (Exception e){
            System.out.println("perform fail...");
        }
    }
}
