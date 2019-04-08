package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.hef.order" ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = EnableWebMvc.class)})
@Import(value = {MongoConfig.class})
public class RootConfig {


}
