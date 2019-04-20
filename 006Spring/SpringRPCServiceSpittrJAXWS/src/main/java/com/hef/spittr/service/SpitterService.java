package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

import java.util.List;

/**
 * @Date 2019-04-15
 * @Author lifei
 */
public interface SpitterService {
    Spitter saveSpitter(Spitter spitter);
    Spitter getSpitter(long id);
    List<Spitter> getAllSpitters();
}
