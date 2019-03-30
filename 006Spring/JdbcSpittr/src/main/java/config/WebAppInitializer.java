package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 使用java 配置方式，进行Spring配置
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


  /*  public WebAppInitializer(){
        super();
        env.setActiveProfiles("qa");
    }*/
    /**
     * 返回带有@Configuration 注解的类， 将用于配置ContextLoaderListener
     * ContextLoaderListener 用于记载驱动后端应用的中间层和数据层
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 返回带有@Configuration 注解的类， 将用于配置 DispatcherServlet
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 将DispatcherServlet映射到 “/” , 表示这会是应用默认的servlet
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter("spring.profiles.active","dev");
        servletContext.setInitParameter("spring.profiles.default", "qa");
    }
}
