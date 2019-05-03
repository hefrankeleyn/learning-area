package com.hef.spittr.service;


import com.hef.spittr.domain.Spitter;

public interface SpitterService {

    Spitter findRandomSpitter();

    Spitter findOneSpitterByUsername(String username);
}
