package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

public interface AlertService {

    void sendSpitter(Spitter spitter);

    void sendMessage(String message);
}
