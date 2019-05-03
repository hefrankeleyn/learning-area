package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Configuration
@PropertySource(value = {"classpath:mail.properties"})
public class EmailConfig {

    /**
     * 配置邮件发送器
     * 属性host是可选的（它默认是底层JavaMail会话的主机)， 可以自己指定要用来发送Email的邮件服务器主机名
     *）默认情况下，JavaMailSenderImpl假设邮件监听端口是25端口（标准的SMTP端口)）
     * @param environment
     * @return
     */
    @Bean
    public JavaMailSender mailSender(Environment environment){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("mailserver.host"));
//        mailSender.setPort(Integer.parseInt(environment.getProperty("mailserver.post")));
        // 如果邮件服务器需要认证的话，还需要设置username 和 password 属性
        mailSender.setUsername(environment.getProperty("mailserver.username"));
        mailSender.setPassword(environment.getProperty("mailserver.password"));
        return mailSender;
    }
}
