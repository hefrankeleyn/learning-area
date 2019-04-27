package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterAlertAsychronizationHandler;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
@Configuration
public class SpitterAlertAsychronizationHandlerImpl implements SpitterAlertAsychronizationHandler {
    @Override
    public void handleSpittleAlert(Spitter spitter) {
        System.out.println("asychronization begin...");
        System.out.println(spitter);
        System.out.println("asychronization end...");
    }
}
