package com.hef.wiring.runtimeautomic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackageClasses = BlankDiscConfig.class)
@PropertySource(value = "classpath:/runtimeautomic/app.properties")
public class BlankDiscConfig {

    /**
     * 从Spring3.1 开始推荐使用 PropertySourcesPlaceholderConfigurer
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
