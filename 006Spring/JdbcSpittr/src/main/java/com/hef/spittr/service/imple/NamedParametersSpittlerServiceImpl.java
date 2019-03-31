package com.hef.spittr.service.imple;

import com.hef.spittr.dao.NamedParametersSpittlerDao;
import com.hef.spittr.entities.Spittler;
import com.hef.spittr.service.NamedParametersSpittlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NamedParametersSpittlerServiceImpl implements NamedParametersSpittlerService {

    @Autowired
    private NamedParametersSpittlerDao namedParametersSpittlerDao;
    @Override
    public void addSpittler(Spittler spittler) {
        namedParametersSpittlerDao.addSpittler(spittler);
    }
}
