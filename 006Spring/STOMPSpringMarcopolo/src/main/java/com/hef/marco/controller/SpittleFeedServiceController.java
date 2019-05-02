package com.hef.marco.controller;

import com.hef.marco.service.SpittleFeedService;
import com.hef.marco.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * @Date 2019-05-02
 * @Author lifei
 */
@Controller
public class SpittleFeedServiceController {

    @Autowired
    private SpittleFeedService spittleFeedService;

    @Autowired
    private SpittleService spittleService;

    /**
     * 定时任务
     */
//    @Scheduled(fixedRate = 1000)
    public void scheduledSend(){
        spittleFeedService.broadcastSpittle(spittleService.findAllSpittle().get(0));
    }
}
