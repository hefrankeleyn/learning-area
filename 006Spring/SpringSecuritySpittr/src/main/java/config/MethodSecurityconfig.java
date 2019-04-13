package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * 设置 securedEnabled 为true， 将会创建一个切点， 这样的话Spring Security 切面就会包装带有 @Secured 注解的方法。
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityconfig extends GlobalMethodSecurityConfiguration {
}
