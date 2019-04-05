package com.hef.spittr.dao.impl;

import com.hef.spittr.dao.SpitterSweeper;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SpitterDaoImpl implements SpitterSweeper {


    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public int updateFullNameByCondition() {

        String update = "update Spitter spitter set spitter.fullName='apple' " +
                "where spitter.updateByEmail=true and spitter.id in (" +
                " select s from Spitter s where s.username='xiao' and (select count(s) from Spitter s where s.username='xiao')>5 )";
        return entityManager.createQuery(update).executeUpdate();
    }
}
