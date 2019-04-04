package com.hef.spittr.dao.imple;

import com.hef.spittr.dao.JpaSpitterDao;
import com.hef.spittr.domain.Spitter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
public class JpaSpitterDaoImpl implements JpaSpitterDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void saveSpitter(Spitter spitter) {
        entityManager.persist(spitter);
    }
}
