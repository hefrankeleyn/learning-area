package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置Spring
 * @Date 2019-04-15
 * @Author lifei
 */
public class WebAppInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置ContextLoaderListener 上下文
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 配置DispatcherServlet Spring上下文
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
