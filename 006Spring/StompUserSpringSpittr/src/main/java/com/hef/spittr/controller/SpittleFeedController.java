package com.hef.spittr.controller;

import com.hef.spittr.domain.Spittle;
import com.hef.spittr.service.SpittleFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Controller
public class SpittleFeedController {

    @Autowired
    private SpittleFeedService spittleFeedService;

    @MessageMapping(value = {"/shout"})
    public void shoutTopic(Spittle spittle){
        spittleFeedService.broadcastSpittle(spittle);
    }
}
