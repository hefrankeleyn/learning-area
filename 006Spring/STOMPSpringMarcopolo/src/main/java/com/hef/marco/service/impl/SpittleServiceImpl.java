package com.hef.marco.service.impl;

import com.hef.marco.dao.SpittleDao;
import com.hef.marco.domain.Spittle;
import com.hef.marco.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
@Component
public class SpittleServiceImpl implements SpittleService {

    @Autowired
    private SpittleDao spittleDao;
    @Override
    public Spittle saveSpittle(Spittle spittle) {
        return spittleDao.save(spittle);
    }

    @Override
    public List<Spittle> findAllSpittle() {
        return spittleDao.findAll();
    }

    @Override
    public Spittle findSpittleById(Long id) {
        return spittleDao.findSpittleById(id);
    }
}
