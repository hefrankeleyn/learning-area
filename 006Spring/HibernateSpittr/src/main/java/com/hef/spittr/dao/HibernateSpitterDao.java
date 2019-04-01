package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;

import java.util.List;

public interface HibernateSpitterDao {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    List<Spitter> findAll();


    Spitter findByFullname(String fullname);
}
