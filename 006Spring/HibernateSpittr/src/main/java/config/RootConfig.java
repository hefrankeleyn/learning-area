package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 配置 ContextLoaderListener
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.hef.spittr",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

    @Autowired
    private SessionFactory sessionFactory;

    // 配置数据源：使用数据源连接池
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/Documents/opt/servers/h2databases/spittr");
        ds.setUsername("spittr");
        ds.setPassword("spittr");
        ds.setInitialSize(5);
        return ds;
    }

    // 装配Hibernate的Session工厂
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan(new String[]{"com.hef.spittr.domain"});
        Properties properties = new Properties();
        properties.setProperty("dialect","org.hibernate.dialect.H2Dialect");
        sfb.setHibernateProperties(properties);
        return sfb;
    }

    /**
     * 解决：org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
