package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Date 2019-04-18
 * @Author lifei
 */
@Configuration
@ComponentScan(basePackages = "com.hef.spittr", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {EnableWebMvc.class})})
@Import(value = {RPCClientHessionConfig.class})
public class RootConfig {
}
