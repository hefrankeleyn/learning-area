package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterAlertHandler;

import java.util.logging.Logger;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
public class SpitterAlertHandlerImpl implements SpitterAlertHandler {

    private static final Logger logger = Logger.getLogger("com.hef.spittr.service.impl.SpitterAlertHandlerImpl");
    @Override
    public void handleSpitterAlert(Spitter spitter) {
        logger.info("handler begin...");

        System.out.println(spitter);

        logger.info("handler end...");
    }
}
