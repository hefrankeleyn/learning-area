package com.hef.spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.io.IOException;

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
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

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

    /**
     * 配置multipart解析器， 部署到Servlet3.0的容器中
     * 必须在web.xml 或servlet 初始化类中，将multipart的具体细节作为DispatcherServlet配置的一部分
     * @return  StanderdServletMultipartResolver
     */
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }


    /**
     * 配置multipart解析器， 部署到非Servlet3.0 的容器中
     * @return
     * @throws IOException
     */
    public MultipartResolver multipartResolver02() throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource("/Users/lifei/Documents/servers/spittr/uploads"));
        multipartResolver.setMaxUploadSize(2097152);
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;
    }


}
