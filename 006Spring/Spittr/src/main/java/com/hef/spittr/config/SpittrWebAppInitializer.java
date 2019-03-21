package com.hef.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @description 添加 dispatcherServlet  ,前端控制器
 * 请求离开浏览器，到达SpringMVC框架的第一站
 *
 *  启动两个应用上下文
 *
 *  Spring Web 应用中，一般有两个应用上下文： 一个是由 DispatcherServer 加载，另一个是由 ContextLoaderListener 加载
 *
 *  我们希望 DispatcherServer  加载包含Web组件的bean，如控制器、试图解析器以及处理器映射，
 *  而 ContextLoaderListener 加载驱动应用后端的中间层和数据层组件的bean
 *
 *  AbstractAnnotationConfigDispatcherServletInitializer 同时创建了 DispatcherServer 和 ContextLoaderListener
 *
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 将DispatcherServlet映射到 “/",表示这会是应用默认的Servlet
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 返回带有 @Configuration 注解的类，将用于配置 ContextLoaderListener
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    /**
     * 返回带有 @Configuration 注解的类，将用于配置 DispatcherServer
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class };
    }


    /**
     * 配置multipart的具体细节
     * 上传文件会临时写入到： /Users/lifei/Documents/servers/spittr/uploads
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/Users/lifei/Documents/servers/spittr/uploads",
                2097152, 4194304, 0));
    }
}
