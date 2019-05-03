package com.hef.spittr.service;


import com.hef.spittr.domain.Spittle;

import java.util.List;

public interface SpittleService {

    Spittle saveSpittle(Spittle spittle);

    List<Spittle> findAllSpittle();

    Spittle findSpittleById(Long id);

    List<Spittle> getRecentSpittles(int size);
}
