package com.hef.spittr.service;


import org.springframework.stereotype.Component;

import javax.management.*;
import java.util.logging.Logger;

@Component
public class PagingNotificationListener implements NotificationListener {

    private static final Logger logger = Logger.getLogger("com.hef.spittr.service.PagingNotificationListener");
    @Override
    public void handleNotification(Notification notification, Object handback) {
        logger.info(notification.getMessage());
        logger.info("Receive notification: " + notification);
    }

}
