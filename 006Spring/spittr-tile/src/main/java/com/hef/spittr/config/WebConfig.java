package com.hef.spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * 启用springmvc
 * 启用组件扫描, 主要扫描控制器（带有 @Controller 注解）
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hef.spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置 JSP试图解析器
     * @return
     */
    /*@Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }*/

    /**
     * 配置静态资源的处理
     * 要求DispatcherServlet将对静态资源的请求转发到servlet容器中默认的servlet上
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    /*
    配置信息源的类
    会到根路径下，找以“messages”为基础名字的文件
     */
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource =
                new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    /*
    除了使用 ResourceBundleMessageSource 的方式外，还可以使用下面的方式
    能够重新加载属性文件，而不必重新编译或重启应用
     */
    public MessageSource messageSource02(){
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("file:///Users/lifei/Documents/opt/properties");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }

    /*
    配置 Tiles 视图解析器, 负责定位和加载tile定义，并协调生成tiles
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] {"/WEB-INF/layout/tiles.xml"});
        tiles.setCheckRefresh(true); // 启用刷新功能
        return tiles;
    }
    /**
     * 将逻辑视图名称解析为Tile定义
     */
    @Bean
    public ViewResolver viewResolver() {
        TilesViewResolver resolver = new TilesViewResolver();
        return resolver;
    }

}
