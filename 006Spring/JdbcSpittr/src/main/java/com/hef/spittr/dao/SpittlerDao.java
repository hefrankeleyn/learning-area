package com.hef.spittr.dao;

import com.hef.spittr.entities.Spittler;

public interface SpittlerDao {

    void addSpittler(Spittler spittler);

    void updateSpittler(Spittler spittler);

    Spittler findOne(String fullName);
}
