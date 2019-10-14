package com.hef.blockqueue;

import org.junit.Test;

/**
 * @Date 2019/10/14
 * @Author lifei
 */
public class BlockingQueueTest {

    @Test
    public void strTest01(){
        String filePath = "filePath";
        int lineNumber = 23;
        String line="welcome to china\n";
        System.out.printf("%s:%d:%s%n", filePath, lineNumber, line);
    }
}
