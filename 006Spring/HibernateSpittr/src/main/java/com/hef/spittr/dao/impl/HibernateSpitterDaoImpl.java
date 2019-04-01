package com.hef.spittr.dao.impl;

import com.hef.spittr.dao.HibernateSpitterDao;
import com.hef.spittr.domain.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class HibernateSpitterDaoImpl implements HibernateSpitterDao {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        Serializable id = currentSession().save(spitter);
        return new Spitter((Long) id,
                spitter.getFullName(),
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getEmail(),
                spitter.getUpdateByEmail());
    }

    @Override
    public Spitter findOne(long id) {
        return currentSession().get(Spitter.class, id);
    }

    @Override
    public List<Spitter> findAll() {
        CriteriaQuery<Spitter> criteriaQuery = currentSession().getCriteriaBuilder().createQuery(Spitter.class);
        criteriaQuery.from(Spitter.class);

        List<Spitter> resultList = currentSession().createQuery(criteriaQuery).getResultList();
        return resultList;

    }

    @Override
    public Spitter findByFullname(String fullName) {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Spitter> query = builder.createQuery(Spitter.class);
        Root<Spitter> root = query.from(Spitter.class);
        query.where(builder.equal(root.get("fullName"),fullName));

        Query<Spitter> q = currentSession().createQuery(query);
        return q.getResultList().get(0);
    }
}
