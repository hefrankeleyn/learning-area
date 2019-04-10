 package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * 配置容器管理类型的JPA
 * ContextLoaderListener
 */
@Configuration
@ComponentScan(basePackages = {"com.hef.spittr"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = EnableWebMvc.class)})
public class ContainerRootConfig {

    /**
     * 配置数据源
     * 使用JNDI 数据源
     * @return DataSource
     */
    @Bean(name = "dataSource")
    @Profile("jndi")
    public JndiObjectFactoryBean dataSource(){
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/spittr");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return jndiObjectFactoryBean;
    }

    /**
     * 配置数据库
     * 使用数据库连接池
     * @return
     */
    @Bean(name = "dataSource")
    @Profile("dev")
    public BasicDataSource dataSourcePool(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/Documents/opt/servers/h2databases/spittr");
        ds.setUsername("spittr");
        ds.setPassword("spittr");
        ds.setInitialSize(5);
        return ds;
    }

    /**
     * 配置jdbc驱动的数据源
     * @return
     */
    @Bean(name = "dataSource")
    @Profile("pro")
    public DataSource dataSourceJdbc(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost:9092/~/Documents/opt/servers/h2databases/spittr");
        ds.setUsername("spittr");
        ds.setPassword("spittr");
        return ds;
    }

    @Bean(name = "dataSource")
    @Profile("qa")
    public DataSource dataSourceInit(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db/schema.sql")
                .addScript("classpath:db/test-data.sql")
                .build();
    }

    /**
     * 使用容器管理类型的JPA
     *
     * @param dataSource
     * @param jpaVendorAdapter 指明使用那一个厂商的JPA实现
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource,
                                                                           JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean emfb =
                new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        // 扫描， 查找带有 @Entity 注解的类
        emfb.setPackagesToScan("com.hef.spittr.domain");
        return emfb;
    }

    /**
     * 使用Hibernate厂商的Jpa实现 jpaVendorAdapter
     * @return
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("");
        return adapter;

    }

    
    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }

    /**
     * 异常转化，不是强制的，
     * 如果希望抛出特定的 JPA 或Hibernate 配置这个
     * @return
     */
    @Bean
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }


    @Configuration
    @EnableTransactionManagement
    public static class TransactionConfig implements TransactionManagementConfigurer {
        @Autowired
        private EntityManagerFactory emf;

        public PlatformTransactionManager annotationDrivenTransactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        }
    }

}
