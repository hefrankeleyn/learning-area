package com.hef.spittr.service;

import com.hef.spittr.entities.Spitter;

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
