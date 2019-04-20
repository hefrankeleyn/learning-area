package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Date 2019-04-20
 * @Author lifei
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置ContextLoaderListener spring上下文
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 配置DispatcherServlet spring上下文
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
