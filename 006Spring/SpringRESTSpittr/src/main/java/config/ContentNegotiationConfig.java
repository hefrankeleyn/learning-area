package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @Date 2019-04-21
 * @Author lifei
 */
@Configuration
public class ContentNegotiationConfig implements WebMvcConfigurer {

    /**
     * 一个特殊的视图解析器，（内容协商）
     * @return
     */
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager contentNegotiationManager){
        ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
        // 设置 contentNegotiationManager
        cnvr.setContentNegotiationManager(contentNegotiationManager);
        return cnvr;
    }

    /**
     * 装配一个 ContentNegotiationManager
     * 配置ComtentNegotiationManager 用于改变 ContentNegotiatingViewResolver（内容协商) 确认媒体的默认行为
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // 摄制默认的内容类型
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }

    /**
     * 以bean形式查找视图
     * @return
     */
    @Bean
    public ViewResolver beanNameViewResolver(){
        return new BeanNameViewResolver();
    }

    /**
     * 将 "spitters" 定义为 JSON 视图
     * @return
     */
    @Bean
    public View spitters(){
        return new MappingJackson2JsonView();
    }
}
