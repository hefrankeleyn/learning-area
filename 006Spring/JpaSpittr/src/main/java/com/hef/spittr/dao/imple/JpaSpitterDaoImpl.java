package com.hef.spittr.dao.imple;

import com.hef.spittr.dao.JpaSpitterDao;
import com.hef.spittr.domain.Spitter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class JpaSpitterDaoImpl implements JpaSpitterDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveSpitter(Spitter spitter) {
        entityManager.persist(spitter);
    }
}
