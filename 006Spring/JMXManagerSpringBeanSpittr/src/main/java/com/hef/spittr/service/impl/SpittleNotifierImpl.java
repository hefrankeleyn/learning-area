package com.hef.spittr.service.impl;

import com.hef.spittr.service.SpittleNotifier;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

import javax.management.Notification;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Component
@ManagedResource(objectName = "spittle:name=SpittleNotifier")
@ManagedNotification(notificationTypes = "SpittleNotifier.OneMillionSpittles", name = "TODO")
public class SpittleNotifierImpl implements NotificationPublisherAware, SpittleNotifier {

    private NotificationPublisher notificationPublisher;

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        this.notificationPublisher = notificationPublisher;
    }

    @Override
    public void millionthSpittlePosted() {
        System.out.println("send messaeg...");
        notificationPublisher.sendNotification(
                new Notification("SpittleNotifier.OneMillionSpittles", this, 0)
        );
        System.out.println("send messaeg success!");
    }
}
