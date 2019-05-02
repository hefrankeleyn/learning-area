package com.hef.marco.controller;

import com.hef.marco.domain.Shout;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
@Controller
public class MarcoController {

    private static final Logger logger = Logger.getLogger("com.hef.marco.controller.MarcoController");

    /**
     * 处理发往 "/app/marco" 目的地的消息
     * @param incoming
     */
//    @MessageMapping("/marco")
//    public void handleShout(Shout incoming){
//        logger.info("Received message: " + incoming.getMessage());
//    }

    @MessageMapping("/marco")
    @SendTo(value = "/topic/marco")
    public Shout handleShout(Shout incoming){
        logger.info("Received message: " + incoming.getMessage());

        Shout outgoing = new Shout();
        outgoing.setMessage("Polo!");
        return outgoing;
    }
}
