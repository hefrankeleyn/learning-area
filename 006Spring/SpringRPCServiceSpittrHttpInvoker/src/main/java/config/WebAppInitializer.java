package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Date 2019-04-20
 * @Author lifei
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 添加映射
     * 将 .service 的扩展，映射到 让HttpInvoker进行处理
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/","*.service"};
    }
}
