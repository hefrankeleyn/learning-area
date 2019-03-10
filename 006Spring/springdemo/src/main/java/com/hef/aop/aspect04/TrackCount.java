package com.hef.aop.aspect04;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCount {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    /**
     *
     * @param trackNumber
     */
    @Pointcut("execution(* com.hef.aop.aspect04.CompactDisc.play(int)) " +
              "&& args(trackNumber)")
    public void performance(int trackNumber){}

    /**
     * 播放前，为该磁道计数
     * @param trackNumber
     */
    @Before("performance(trackNumber)")
    public void watchPerformance(int trackNumber){
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.containsKey(trackNumber)
                ? trackCounts.get(trackNumber) : 0;
    }
}
