package com.hef.aop.aspectj;

import com.hef.aop.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/aop/aspectj/aspectj-config.xml")
public class EncoreableTest {

    @Autowired
    private Performance performance;

    @Test
    public void performanceShouldNotNull(){
        assertNotNull(performance);
    }

    @Test
    public void testPerform(){
        performance.perform();
    }

}
