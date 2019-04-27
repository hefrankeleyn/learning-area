package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

public interface SpitterAlertAsychronizationHandler {

    void handleSpittleAlert(Spitter spitter);
}
