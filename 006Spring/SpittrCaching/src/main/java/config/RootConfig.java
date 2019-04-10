package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 *  使用容器管理类型的JPA
 */
@Configuration
@ComponentScan(basePackages = "com.hef.spittr", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = EnableWebMvc.class)})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.hef.spittr.dao", entityManagerFactoryRef = "entityManagerFactoryBean")
public class RootConfig {

    /**
     * 配置数据源， 使用连接池
     * @return
     */
    @Bean
    public DataSource dataSource(){
        BasicDataSource  ds= new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/Documents/opt/servers/h2databases/spittr");
        ds.setUsername("spittr");
        ds.setPassword("spittr");
        ds.setInitialSize(5);
        return ds;
    }


    /**
     * 使用容器管理的JPA
     * @param dataSource
     * @param jpaVendorAdapter
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource,
                                                                           JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean emfb =
                new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        // 扫描， 查找带有@Entiry 注解的类
        emfb.setPackagesToScan("com.hef.spittr.domain");
        return emfb;
    }

    /**
     * 使用hibernate厂商的 JpaVendorAdapter
     * @return
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter =
                new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        return jpaVendorAdapter;
    }

    /**
     * @PersistenceContext 该注解是JPA规范提供的， 为了让Spring理解这些注解，并注入EntityManager，
     * 必须要配置 PersistenceAnnotationBeanPostProcessor
     * <context:annotation-config></context:annotation-config>  或 <context:component-scan></context:component-scan>
     * 注解会自动注册 PersistenceAnnotationBeanPostProcessor
     * @return
     */
    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }

    /**
     * 解决：org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
     * @param entityManagerFactory
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager =
                new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

}
