package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

public interface JMSRPCService {

    Spitter findSpitterById(long id);
}
