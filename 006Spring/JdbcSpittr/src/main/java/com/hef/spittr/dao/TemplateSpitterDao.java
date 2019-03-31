package com.hef.spittr.dao;

import com.hef.spittr.entities.Spittler;

public interface TemplateSpitterDao {

    Spittler findOneSpittler(String fullname);

    void addSpitter(Spittler spittler);

    Spittler lambdaFindOneSpitter(String fullname);

    Spittler methodReferenceFindOneSpitter(String fullname);
}

