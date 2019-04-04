package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

/**
 * 配置 ServletLoaderConfig
 */
@Configuration
//@EnableTransactionManagement
@ComponentScan(basePackages = "com.hef.spittr",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = EnableWebMvc.class)})
public class RootConfig {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean emfb =
                new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("spittr-unit");
        return emfb;
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

    public static void main(String[] args) {
        AnnotationConfigApplicationContext con =
                new AnnotationConfigApplicationContext(RootConfig.class);
        EntityManagerFactory emf = con.getBean(EntityManagerFactory.class);

        EntityManager em = emf.createEntityManager();
        try{
            nativeQuery(em,"SHOW COLUMNS FROM SPITTLE");
        }finally {
            em.close();
            emf.close();
        }
    }

    private static void nativeQuery(EntityManager em, String s){
        System.out.printf("......%n'%s'%n", s);
        Query query = em.createNativeQuery(s);
        List list = query.getResultList();
        for (Object o : list){
            if (o instanceof Object[]){
                System.out.println(Arrays.toString((Object[]) o));
            } else {
                System.out.println(o);
            }
        }
    }
}
