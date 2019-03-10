package com.hef.wiring.runtimeautomic;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlankDiscConfig.class)
public class BlankDiscTest {

    @Rule
    public final SystemOutRule log= new SystemOutRule().enableLog();

    @Autowired
    private BlankDisc blankDisc;

    @Autowired
    private PropertySourcesPlaceholderConfigurer placeholderConfigurer;


    @Test
    public void blankDiscShouldNotNull(){
        Assert.assertNotNull(blankDisc);
    }

    @Test
    public void placeholderConfigurerShouldNotNull(){
        Assert.assertNotNull(placeholderConfigurer);
    }

    @Test
    public void testPlay(){
        blankDisc.play();
        Assert.assertEquals("I'm trying autowiring, Li Fei\n",log.getLog());
    }
}
