package com.hef.aop.aspect01;

import com.hef.aop.FailPerformance;
import com.hef.aop.Performance;
import com.hef.aop.SingPerformance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *@param  @EnableAspectJAutoProxy   启动自动代理功能
 */
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean
    public Performance performance(){
        return new SingPerformance();
    }


    @Bean
    public Performance failePerformance(){
        return new FailPerformance();
    }

    @Bean
    public Audience audience(){
        return new Audience();
    }
}
