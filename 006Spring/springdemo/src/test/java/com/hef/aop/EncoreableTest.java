package com.hef.aop;

import static org.junit.Assert.*;

import com.hef.aop.aspect05.Encoreable;
import com.hef.aop.aspect05.EncoreableConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EncoreableConfig.class)
public class EncoreableTest {

    @Autowired
    private Performance performance;

    @Autowired
    private Encoreable encoreable;

    @Test
    public void performanceShouldNotNull(){
        assertNotNull(performance);
    }

    @Test
    public void methodTest(){
        performance.perform();
        encoreable.performEncore();
    }
}
