package com.hef.wiring.multi01;

import com.hef.wiring.xmlwiring.CDPlayer;
import com.hef.wiring.xmlwiring.CompactDisc;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void compactDiscShouldNotNull(){
        Assert.assertNotNull(compactDisc);
    }

    @Test
    public void cdPlayerShouldNotNull(){
        Assert.assertNotNull(cdPlayer);
    }

    @Test
    public void testPlayer(){
        cdPlayer.play();
        Assert.assertEquals("Playing Sgt. Peppers's Lonely Hearts Club Band. by The Beatles\n",log.getLog());
    }


}
