package com.hef.others;

import com.hef.wiring.xmlwiring.CDPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ClasspathTest {


    @Test
    public void classPath() throws IOException {
        try (InputStream in = CDPlayer.class.getResourceAsStream("cdplayer.xml")){
            Assert.assertNull(in);
        }

    }
}
