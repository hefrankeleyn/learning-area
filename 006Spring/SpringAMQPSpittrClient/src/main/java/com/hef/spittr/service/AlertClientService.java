package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

public interface AlertClientService {

    String receiveMessage();

    Spitter receiveSpitter();
}
