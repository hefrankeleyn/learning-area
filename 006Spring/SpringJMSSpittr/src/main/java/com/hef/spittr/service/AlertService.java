package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

public interface AlertService {

    void sendSpitterAlert(Spitter spitter);

    void convertAndSend(Spitter spitter);

    void sendTopicMesage(String message);

    void sendTopicSpitterMesage(Spitter message);
}
