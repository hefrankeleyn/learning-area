package com.hef.spittr.config;

import com.hef.spittr.service.SpitterUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 基于内存的用户存储
     * inMemoryAuthentication() 启动用户存储
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        // 用两个用户来配置内存用户存储
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new SpitterUserService());
    }*/

    /**
     * 对每个请求进行细粒度安全性控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
             .and()
                .httpBasic().realmName("SpittrSecurity")
            .and()// 启用remember me
            .rememberMe()
                .tokenValiditySeconds(241920)
                .key("spittrKey")
            .and()
            .authorizeRequests()
                .antMatchers("/spittles").access("isAuthenticated() and principal.username=='admin'")
                .antMatchers("/spitters/me").authenticated()
                .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                .regexMatchers("/spitters/.*").authenticated()
                .anyRequest().permitAll();
        // 配置权限
//        http.authorizeRequests()
//                .antMatchers("/spitters/me").hasAuthority("ROLE_SPITTER")
//                .antMatchers(HttpMethod.POST, "/spittles").hasAuthority("ROLE_SPITTER")
//                .anyRequest().permitAll();
        // 上面的等价于
//        http.authorizeRequests()
//                .antMatchers("/spitters/me").hasRole("SPITTER")
//                .antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")
//                .anyRequest().permitAll();
    }


    /**
     * 使用SpEL对每个请求进行细粒度安全性控制
     * @param http
     * @throws Exception
     */
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/spitter/me")
                    .access("hasRole('ROLE_SPITTER')");

        http.authorizeRequests()
                .antMatchers("/spitter/me")
                    .access("hasRole('ROLE_SPITTER') and hasIpAddress('192.168.1.2')");

    }*/

    /**
     * 强制通道的安全性
     * @param http
     * @throws Exception
     */
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/spitter/me").hasRole("SPITTER")
                .antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")
                .antMatchers().permitAll()
             .and()
             .requiresChannel()
                .antMatchers("/spitter/form").requiresSecure();// 需要HTTPS
    }*/
}
