package com.hef.aop.xml;

import com.hef.aop.aspect04.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:/aop/xml/audience-config03.xml")
public class BlankDiscTest {

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void compactDiscShouldNotNull(){
        assertNotNull(compactDisc);
    }

    @Test
    public void trackCountShouldNotNull(){
        assertNotNull(trackCounter);
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

        assertEquals(2, trackCounter.getPlayCount(0));
        assertEquals(5, trackCounter.getPlayCount(1));
        assertEquals(1, trackCounter.getPlayCount(2));
        assertEquals(2, trackCounter.getPlayCount(3));
        assertEquals(3, trackCounter.getPlayCount(4));
    }


}
