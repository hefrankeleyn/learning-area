package com.hef.spittr.controller;

import com.hef.spittr.domain.Spittle;
import com.hef.spittr.service.SpittleFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Controller
public class SpittleFeedController {

    private static final Logger logger = Logger.getLogger("com.hef.spittr.controller.SpittleFeedController");

    @Autowired
    private SpittleFeedService spittleFeedService;

    @MessageMapping(value = {"/shout"})
    public void shoutTopic(Spittle spittle){
        spittleFeedService.broadcastSpittle(spittle);
    }

    /**
     * 处理异常
     * @param t
     */
    @MessageExceptionHandler
    public void handleExceptions(Throwable t){
        logger.info("Error hanling messagge: " + t.getMessage());
    }
}
