package com.hef.spittr.dao.imple;

import com.hef.spittr.dao.ContainerJpaSpitterDao;
import com.hef.spittr.domain.Spitter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 不使用 Spring tpaTemplate的JPA Repository
 */
@Repository
@Transactional
public class ContainerJpaSpitterDaoImpl implements ContainerJpaSpitterDao {

    /**
     * 注入 EntityManager
     * 是 EntityManager的代理， 真正的EntityManager 是与当前事务相关联的那一个
     *
     * @PersistenceContext 该注解是JPA规范提供的， 为了让Spring理解这些注解，并注入EntityManager，必须要配置 PersistenceAnnotationBeanPostProcessor
     * <context:annotation-config></context:annotation-config>  或 <context:component-scan></context:component-scan>
     * 注解会自动注册 PersistenceAnnotationBeanPostProcessor
     */
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addSpitter(Spitter spitter) {
        entityManager.persist(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return entityManager.find(Spitter.class, id);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        entityManager.merge(spitter);
    }
}
