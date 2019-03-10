package com.hef.wiring.xmlwiring;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/xmlwiring/cdplayer.xml")
public class CDPlayerTest {

    /*
    能够基于控制台的输出编写断言
     */
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private CDPlayer cdPlayer;

    @Autowired
    private CDPlayer cdPlayer00;

    @Autowired
    private CompactDisc blankDisc;

    @Autowired
    private CompactDisc blankDisc02;

    @Autowired
    private CompactDisc multiDiscNull01;

    @Autowired
    private CompactDisc multiDiscList02;

    @Test
    public void allCdPlayerShouldNotNull(){
        Assert.assertNotNull(cdPlayer);
        Assert.assertNotNull(cdPlayer00);
    }

    @Test
    public void allDiscShouldNotNull(){
        Assert.assertNotNull(blankDisc);
        Assert.assertNotNull(blankDisc02);
        Assert.assertNotNull(multiDiscNull01);
        Assert.assertNotNull(multiDiscList02);
    }

    @Test
    public void cdPlayerTest(){
        cdPlayer.play();
        Assert.assertNotNull("Playing Sgt. Peppers's Lonely Hearts Club Band. by The Beatles\n",log.getLog());
    }
    @Test
    public void cdPlayer00Test(){
        cdPlayer.play();
        Assert.assertNotNull("Playing Sgt. Peppers's Lonely Hearts Club Band. by The Beatles\n",log.getLog());
    }


}
