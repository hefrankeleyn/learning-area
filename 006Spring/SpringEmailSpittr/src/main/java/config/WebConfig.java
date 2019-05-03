package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import java.util.Set;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.hef.spittr"})
public class WebConfig implements WebMvcConfigurer {

    /**
     * 将逻辑视图名和 Thymeleaf 视图进行映射
     * @param templateEngine
     * @return
     */
    @Bean
    public ViewResolver viewResolver(TemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    /**
     * 解析视图和视图映射
     * @return
     */
    /*@Bean
    public TemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }*/

    /**
     * 解析视图和视图映射
     * 使用两个视图解析器
     * @param resolvers
     * @return
     */
    @Bean
    public TemplateEngine templateEngine(Set<ITemplateResolver> resolvers){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolvers(resolvers);
        return templateEngine;
    }

    /**
     * 加载视图
     * 模板解析器2
     * @param servletContext
     * @return
     */
    @Bean
    public ITemplateResolver templateResolver(ServletContext servletContext){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setOrder(2);
        return templateResolver;
    }

    /**
     * 加载位于类路径根的“mail” 下的html
     * 模板解析器1
     * @return
     */
    @Bean
    public ITemplateResolver emailTemplateResolver(){
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("/mail/");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
