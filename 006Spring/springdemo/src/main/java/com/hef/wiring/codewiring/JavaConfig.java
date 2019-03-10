package com.hef.wiring.codewiring;

import com.hef.wiring.automic.MediaPlayer;
import org.springframework.context.annotation.Bean;

public class JavaConfig {

    /**
    @description @Bean 告诉Spring这个方法将会返回一个对象
    Bean 的名字默认会是 sgtPeppers
     */
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    /**
     * Bean 的名字将会是 randomBeatlesCD
     * @return
     */
    @Bean
    public CompactDisc randomBeatlesCD() {
        int chooice = (int) Math.floor(Math.random()*4);
        if (chooice == 0) {
            return new SgtPeppers();
        } else if (chooice == 1) {
            return new WhiteAlbum();
        } else if (chooice == 2) {
            return new HardDaysNight();
        } else {
            return new Revolver();
        }
    }

    /**
     * 实现注入
     * Spring 会拦截所有对它的调用，并确保直接返回该方法所创建的bean，而不是每次都对其进行实际的调用
     * @return
     */
    @Bean
    public MediaPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    /**
     * 通过这种方式实现引入其他的bean通常是最佳的选择，因为它不会要求将CompactDisc 声明到同一个类中。
     * 甚至可以通过组建扫描功能自动发现或通过xml来进行配置
     * @param compactDisc
     * @return
     */
    @Bean(name = "randomBeatlesCD")
    public MediaPlayer anotherCDPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

}
