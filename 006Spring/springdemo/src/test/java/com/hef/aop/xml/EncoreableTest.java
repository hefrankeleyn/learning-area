package com.hef.aop.xml;

import com.hef.aop.Performance;
import com.hef.aop.aspect05.Encoreable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/aop/xml/audience-config04.xml")
public class EncoreableTest {

    @Autowired
    private Performance performance;

    @Autowired
    private Encoreable defaultEncoreable;

    @Test
    public void performanceShouldNotNull(){
        assertNotNull(performance);
    }

    @Test
    public void methodTest(){
        performance.perform();
        defaultEncoreable.performEncore();
    }
}
