package com.hef.spittr.service.impl;

import com.hef.spittr.dao.SpitterDao;
import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
@Service
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterDao spitterDao;
    @Override
    public Spitter findRandomSpitter() {
        List<Spitter> spitters = spitterDao.findAll();
        if(!spitters.isEmpty()){
            int size = spitters.size();
            Random random = new Random();
            int i = random.nextInt(size);
            return spitters.get(i);
        }
        return null;
    }

    @Override
    public Spitter findOneSpitterByUsername(String username){
        List<Spitter> spitters = spitterDao.findSpittersByUsername(username);
        if(!spitters.isEmpty()){
            return spitters.get(0);
        }
        return null;
    }
}
