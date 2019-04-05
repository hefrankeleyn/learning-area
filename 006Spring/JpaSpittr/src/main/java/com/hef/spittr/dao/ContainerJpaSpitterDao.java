package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;

public interface ContainerJpaSpitterDao {

    void addSpitter(Spitter spitter);

    Spitter getSpitterById(long id);

    void saveSpitter(Spitter spitter);

}
