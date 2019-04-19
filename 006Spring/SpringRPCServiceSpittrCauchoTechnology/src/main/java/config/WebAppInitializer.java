package config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.Properties;

/**
 * 配置Spring
 * @Date 2019-04-18
 * @Author lifei
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置 ContextLoaderListener 上下文
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 配置DispatcherServlet 上下文
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 为了处理Hession服务，DispatcherServlet 还需要配置一个Servlet映射来拦截后缀为 *.service 的URL
     * 为了保证请求转给hessionSpitterService 处理，还需要配置一个URL映射。
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/", "*.service"};
    }

}
