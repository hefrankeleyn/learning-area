package com.hef.spittr.service.impl;

import com.hef.spittr.dao.SpitterDao;
import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Date 2019-04-15
 * @Author lifei
 */
@Component
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterDao spitterDao;
    @Override
    public Spitter saveSpitter(Spitter spitter) {
        Spitter save = spitterDao.save(spitter);
        return save;
    }

    @Override
    public Spitter getSpitter(long id) {
        return spitterDao.getOne(id);
    }

    @Override
    public List<Spitter> getAllSpitters() {
        return spitterDao.findAll();
    }

    @Override
    public Spitter findSpitterByName(String username) {
        List<Spitter> spitters = spitterDao.findSpitterByUsername(username);
        if (spitters != null && !spitters.isEmpty()){
            return spitters.get(0);
        }
        return null;
    }
}
