package com.hef.wiring.codewiring;

import com.hef.wiring.automic.MediaPlayer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
public class CDPlayerTest {

    /**
     * 这里的变量名字不能随便命名，必须和借助JavaConfig实现注入的ID一样。
     */
    @Autowired
    private MediaPlayer cdPlayer;

    /*
    能够基于控制台的输出编写断言
     */
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void meidaPlayerShouldNotNull(){
        Assert.assertNotNull(cdPlayer);
    }
    @Test
    public void testPlayer() {
        cdPlayer.play();
        Assert.assertEquals("Playing Sgt. Peppers's Lonely Hearts Club Band. by The Beatles\n", log.getLog());
    }
}
