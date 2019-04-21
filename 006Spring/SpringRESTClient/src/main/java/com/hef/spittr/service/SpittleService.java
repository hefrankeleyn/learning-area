package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

public interface SpittleService {


    Spitter fetchSpitterById(Long id);

    Spitter findSpitterById(Long id);

    Spitter getSpitterById(Long id);
}


