package config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 配置 ContextLoaderListener 上下文
 * @Date 2019-04-27
 * @Author lifei
 */
@Configuration
@ComponentScan(basePackages = {"com.hef.spittr"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {EnableWebMvc.class})})
@Import(value = {SpringDataJpaConfig.class})
@ImportResource(locations = {"classpath:/spring/rabbitmq-config-second-method.xml"})
public class RootConfig {
}
