package com.hef.spittr.service.impl;

import com.hef.spittr.jaxws.client.Spitter;
import com.hef.spittr.jaxws.client.SpitterServiceEndpoint;
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
    private SpitterServiceEndpoint spitterService;

    @Override
    public Spitter findSpitterById(long id) {
        Spitter spitter = spitterService.findSpitterById(id);
        return spitter;
    }

    @Override
    public List<Spitter> getAllSpitter() {
        return spitterService.findAllSpitters();
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        spitterService.saveSpitter(spitter);
    }

}
