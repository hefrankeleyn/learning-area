package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 *  注解 EnableJpaRepositories， 配置ContextLoaderListenerDataAPI的所有魔力， 扫描基础包，来查找拓展自Spring Data JPA Repository接口的所有接口，
 * 如果发现拓展自Repository的接口， 它会自动生成这个接口的实现。
 */
@Configuration
@ComponentScan(basePackages = {"com.hef.spittr"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = EnableWebMvc.class)})
@EnableJpaRepositories(basePackages = "com.hef.spittr.dao", entityManagerFactoryRef = "entityManagerFactoryBean")
public class RootConfig {

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
        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        return adapter;

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
     * 异常转化，不是强制的，
     * 如果希望抛出特定的 JPA 或Hibernate 配置这个
     * @return
     */
    @Bean
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        return jpaTransactionManager;
    }

}
