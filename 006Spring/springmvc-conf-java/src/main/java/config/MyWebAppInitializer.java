package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 通过 Java配置两个 Spring上下文： DispatcherServlet 和 ContextLoadListener
 * 跟踪SpringMVC的请求
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 这个方法使用来配置 ContextLoadListener
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 这个方法是用来配置 DispatcherServlet
     * @return 返回带有@Configuration 注解的类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * DispatcherServlet 的映射，将DispatcherServlet映射到“/”
     * @return 返回带有@Configuration 注解的类
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
