package com.hef.marco.controller;

import com.hef.marco.domain.Shout;
import com.hef.marco.service.ShoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

/**
 * @Date 2019-05-02
 * @Author lifei
 */
@Controller
public class MarcoController {

    private static final Logger loger = Logger.getLogger("com.hef.marco.controller.MarcoController");

    @Autowired
    private ShoutService shoutService;

    @MessageMapping(value = "/marco")
    public Shout marcoRece(Shout incoming){
        loger.info("receive: " + incoming);
        Shout outgoing = new Shout();
        outgoing.setMessage("love");
        return outgoing;
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleShout(){
        shoutService.shoutStr();
    }

}
