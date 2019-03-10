package com.hef.wiring.multi03;

import com.hef.wiring.xmlwiring.CDPlayer;
import com.hef.wiring.xmlwiring.CompactDisc;
import com.hef.wiring.xmlwiring.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  混合装配
 *  在 JavaConfig 中引入 xml装配
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public CDPlayer compactDisc(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }


}
