package com.hef.aop;

import com.hef.aop.aspect04.CompactDisc;
import com.hef.aop.aspect04.TrackCount;
import com.hef.aop.aspect04.TrackCounterConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class AudienceTest04 {

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private TrackCount trackCount;

    @Test
    public void compactDiscShouldNotNull(){
        assertNotNull(compactDisc);
    }

    @Test
    public void trackCountShouldNotNull(){
        assertNotNull(trackCount);
    }

    @Test
    public void testTrackCounter(){
        compactDisc.play(0);
        compactDisc.play(0);
        compactDisc.play(1);
        compactDisc.play(1);
        compactDisc.play(1);
        compactDisc.play(1);
        compactDisc.play(1);
        compactDisc.play(2);
        compactDisc.play(3);
        compactDisc.play(3);
        compactDisc.play(4);
        compactDisc.play(4);
        compactDisc.play(4);

        assertEquals(2, trackCount.getPlayCount(0));
        assertEquals(5, trackCount.getPlayCount(1));
        assertEquals(1, trackCount.getPlayCount(2));
        assertEquals(2, trackCount.getPlayCount(3));
        assertEquals(3, trackCount.getPlayCount(4));
    }


}
