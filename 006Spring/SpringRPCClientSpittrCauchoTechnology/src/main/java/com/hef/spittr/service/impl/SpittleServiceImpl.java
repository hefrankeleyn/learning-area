package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterService;
import com.hef.spittr.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Date 2019-04-15
 * @Author lifei
 */
@Component
public class SpittleServiceImpl implements SpittleService {

    @Autowired
    private SpitterService spitterService;

    @Override
    public Spitter findSpitterById(long id) {
        Spitter spitter = spitterService.getSpitter(id);
        return spitter;
    }

    @Override
    public List<Spitter> getAllSpitter() {
        return spitterService.getAllSpitters();
    }

    @Override
    public Spitter saveSpitter(Spitter spitter) {
        return spitterService.saveSpitter(spitter);
    }

}
