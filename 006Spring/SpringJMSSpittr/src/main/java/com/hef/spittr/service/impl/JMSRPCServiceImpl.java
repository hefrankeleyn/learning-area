package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.JMSRPCService;
import com.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
@Component
public class JMSRPCServiceImpl implements JMSRPCService {

    @Autowired
    private SpitterService spitterService;
    @Override
    public Spitter findSpitterById(long id) {
        System.out.println("id:" + id);
        return spitterService.getSpitter(id);
    }
}
