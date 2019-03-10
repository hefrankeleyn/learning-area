package com.hef.wiring.xmlproperty;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/xmlproperty/cdplayer.xml")
public class CDPlayerTest {


    /*
    能够基于控制台的输出编写断言
     */
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();


    @Autowired
    private SgtPeppers sgtPeppers;

    @Autowired
    private CDPlayer cdPlayer;
    @Autowired
    private CDPlayer cdPlayer02;

    @Autowired
    private BlankDisc blankDisc01;
    @Autowired
    private BlankDisc blankDisc02;
    @Autowired
    private BlankDisc blankDisc03;
    @Test
    public void sgtPeppersShouldNotNull(){
        Assert.assertNotNull(sgtPeppers);
        Assert.assertNotNull(blankDisc01);
        Assert.assertNotNull(blankDisc02);
        Assert.assertNotNull(blankDisc03);
    }

    @Test
    public void cdPlayShouldNotnull(){
        Assert.assertNotNull(cdPlayer);
        Assert.assertNotNull(cdPlayer02);
    }

    @Test
    public void testCDPlayer(){
        cdPlayer.play();
        Assert.assertEquals("Playing Sgt. Peppers's Lonely Hearts Club Band. by The Beatles\n",log.getLog());
        cdPlayer02.play();
        Assert.assertEquals("Playing Sgt. Peppers's Lonely Hearts Club Band. by The Beatles\n",log.getLog());
    }
    @Test
    public void testCDPlayer02(){
        cdPlayer02.play();
        Assert.assertEquals("Playing Sgt. Peppers's Lonely Hearts Club Band. by The Beatles\n",log.getLog());
    }
}
