package com.hef.spittr.controller;

import com.hef.spittr.domain.Notification;
import com.hef.spittr.domain.Spitter;
import com.hef.spittr.domain.Spittle;
import com.hef.spittr.service.SpitterService;
import com.hef.spittr.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

/**
 * @Date 2019-05-02
 * @Author lifei
 */
@Controller
public class SpittleController {

    @Autowired
    private SpittleService spittleService;

    @Autowired
    private SpitterService spitterService;


    /**
     * 当前往“/app/spittle” 目的的消息到达时，该方法触发，并会根据消息创建SpittleForm对象
     * @param principal
     * @param spi
     * @return
     */
    @MessageMapping("/spittle")
    @SendToUser("/queue/notifications")
    public Notification handleSpittle(Principal principal, Spittle spi){
        String username = principal.getName();
        Spitter spitter = spitterService.findOneSpitterByUsername(username);
        Spittle spittle = new Spittle(spitter.getId(),spi.getMessage(), new Date(), spi.getLatitude(), spi.getLongitude());

        return new Notification("Saved Spittle");

    }
}
