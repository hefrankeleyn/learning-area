package com.hef.spittr.service.impl;

import com.hef.spittr.service.JMSRPCService;
import com.hef.spittr.service.SpitterRPCClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
@Component
public class SpitterRPCClientServiceImpl implements SpitterRPCClientService {

    @Autowired
    private JMSRPCService jMSRPCService;
}
