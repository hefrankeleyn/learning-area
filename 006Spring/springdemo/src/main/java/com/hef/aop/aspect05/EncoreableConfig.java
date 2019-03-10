package com.hef.aop.aspect05;

import com.hef.aop.SingPerformance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class EncoreableConfig {

    @Bean
    public SingPerformance performance(){
        return new SingPerformance();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer(){
        return new EncoreableIntroducer();
    }
}
