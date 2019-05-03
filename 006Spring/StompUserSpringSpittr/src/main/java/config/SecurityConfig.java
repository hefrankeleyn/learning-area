package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * @Date 2019-05-02
 * @Author lifei
 */
@Configuration
@EnableWebSecurity  // 启用Web安全性
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    /**
     * 选择查询用户信息的服务
     * 并重写默认的用户查询功能
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, true " +
                                "from Spitter where username=?"
                ).authoritiesByUsernameQuery(
                        "select username,'ROLE_USER' from Spitter where username=?"
                );
    }

    /**
     * 拦截请求
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
              .and()
                .rememberMe()
                .tokenValiditySeconds(241920)
                .key("spitterKey")
              .and()
                .httpBasic().realmName("StompUserSpringSpittr")
              .and()
                .authorizeRequests()
                .antMatchers("/spitterController/spitter").authenticated()
                .antMatchers("/").authenticated()
                .antMatchers("/home").authenticated()
                .anyRequest().permitAll();
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
    }*/
}
