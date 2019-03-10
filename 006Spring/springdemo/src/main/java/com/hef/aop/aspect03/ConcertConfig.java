package com.hef.aop.aspect03;

import com.hef.aop.FailPerformance;
import com.hef.aop.Performance;
import com.hef.aop.SingPerformance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class ConcertConfig {
    @Bean
    public Performance performance(){
        return new SingPerformance();
    }


    @Bean
    public Performance failPerformance(){
        return new FailPerformance();
    }

    @Bean
    public Audience audience(){
        return new Audience();
    }
}
