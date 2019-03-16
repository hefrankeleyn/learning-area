package com.hef.spittr.service;

import com.hef.spittr.entities.Spittle;

import java.util.List;

public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);

}
