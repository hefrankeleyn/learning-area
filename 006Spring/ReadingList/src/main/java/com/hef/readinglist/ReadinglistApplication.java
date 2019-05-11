package com.hef.readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadinglistApplication {

    // 继承 SpringBootServletInitializer 后实现
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(this.getClass());
        return super.configure(builder);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ReadinglistApplication.class, args);
    }

}
