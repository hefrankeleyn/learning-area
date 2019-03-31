package com.hef.spittr.service.imple;

import com.hef.spittr.dao.TemplateSpitterDao;
import com.hef.spittr.entities.Spittler;
import com.hef.spittr.service.TemplateSpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemplateSpitterServiceImpl implements TemplateSpitterService {

    @Autowired
    private TemplateSpitterDao templateSpitterDao;
    @Override
    public Spittler findOneSpitter(String fullname) {
        return templateSpitterDao.findOneSpittler(fullname);
    }

    @Override
    public void addSpitter(Spittler spittler) {
        templateSpitterDao.addSpitter(spittler);
    }

    @Override
    public Spittler lambdaFindOneSpitter(String fullname) {
        return templateSpitterDao.lambdaFindOneSpitter(fullname);
    }

    @Override
    public Spittler methodReferenceFindOneSpitter(String fullname) {
        return templateSpitterDao.methodReferenceFindOneSpitter(fullname);
    }
}
