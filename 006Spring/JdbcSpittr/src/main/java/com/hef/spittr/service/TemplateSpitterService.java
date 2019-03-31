package com.hef.spittr.service;

import com.hef.spittr.entities.Spittler;

public interface TemplateSpitterService {

    Spittler findOneSpitter(String fullname);

    void addSpitter(Spittler spittler);

    Spittler lambdaFindOneSpitter(String fullname);


    Spittler methodReferenceFindOneSpitter(String fullname);
}
