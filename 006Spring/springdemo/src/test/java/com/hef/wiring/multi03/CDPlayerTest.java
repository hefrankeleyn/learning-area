package com.hef.wiring.multi03;

import com.hef.wiring.xmlwiring.CDPlayer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试在JavaConfig中注入xml
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class CDPlayerTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private CDPlayer cdPlayer;

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void cdPlayerShouldNotNull(){
        Assert.assertNotNull(cdPlayer);
    }

    @Test
    public void blankDiscShouldNotNull(){
        Assert.assertNotNull(blankDisc);
    }

    @Test
    public void testCDPlayer(){
        cdPlayer.play();
        Assert.assertEquals("Playing Multi,People's love by The Multi\n" +
                "Multi01\n" +
                "Multi04\n" +
                "Multi03\n" +
                "Multi02\n",log.getLog());
    }
}
