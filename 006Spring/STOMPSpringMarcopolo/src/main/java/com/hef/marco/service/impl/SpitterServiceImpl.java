package com.hef.marco.service.impl;

import com.hef.marco.dao.SpitterDao;
import com.hef.marco.domain.Spitter;
import com.hef.marco.service.SpitterService;
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
}
