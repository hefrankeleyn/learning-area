package config;

import con.hef.spittr.security.SpitterPermissionEvaluator;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * 设置 securedEnabled 为true， 将会创建一个切点， 这样的话Spring Security 切面就会包装带有 @Secured 注解的方法。
 *
 * 同时开启 @Secured注解 和 JSR-250 的 @RolesAllowed注解
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class MethodSecurityconfig extends GlobalMethodSecurityConfiguration {


    /**
     * 使用自定义的许可认证器
     * @return
     */
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new SpitterPermissionEvaluator());
        return expressionHandler;
    }
}
