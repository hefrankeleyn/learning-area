package com.hef.marco.service;

import com.hef.marco.domain.Spittle;

import java.util.List;

public interface SpittleService {

    Spittle saveSpittle(Spittle spittle);

    List<Spittle> findAllSpittle();

    Spittle findSpittleById(Long id);
}
