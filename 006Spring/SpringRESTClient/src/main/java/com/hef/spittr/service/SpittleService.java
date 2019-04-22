package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;
import org.springframework.http.ResponseEntity;

public interface SpittleService {


    Spitter fetchSpitterById(Long id);

    Spitter findSpitterById(Long id);

    Spitter getSpitterById(Long id);

    void updateSpitter(Spitter spitter);

    void deleteSpitterById(Long id);

    Spitter saveSpitter(Spitter spitter);

    ResponseEntity<Spitter> saveSpitterEntity(Spitter spitter);

    String saveSpitterAndFetchLocation(Spitter spitter);

    ResponseEntity<Spitter> findSpitterByIdByExchange(Long id);
}


