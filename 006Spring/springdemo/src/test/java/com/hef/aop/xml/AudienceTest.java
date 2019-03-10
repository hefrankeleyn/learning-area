package com.hef.aop.xml;


import com.hef.aop.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/aop/xml/audience-config.xml")
public class AudienceTest {

    @Autowired
    private Performance singPerformance;

    @Autowired
    private Performance failPerformance;
    @Test
    public void performanceShouldNotNull(){
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
            System.out.println("perform fail...");
        }
    }
}
