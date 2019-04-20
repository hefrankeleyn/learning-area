package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 配置ContextLoaderListener 上下文
 * @Date 2019-04-20
 * @Author lifei
 */
@Configuration
@ComponentScan(basePackages = "com.hef.spittr", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {EnableWebMvc.class})})
@Import(value = {SpringDataJpaConfig.class, SpringHttpInvokerConfig.class})
public class RootConfig {
}
