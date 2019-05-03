package config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @Date 2019-05-03
 * @Author lifei
 */

/**
 * 配置 DelegatingFilterProxy, 用于拦截请求
 * Spring会识别这个类
 * AbstractSecurityWebApplicationInitializer 实现了 WebApplicationInitializer，
 * 因此Spring会发现它，并用它在Web容器注册 DelegatingFilterProxy。
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
}
