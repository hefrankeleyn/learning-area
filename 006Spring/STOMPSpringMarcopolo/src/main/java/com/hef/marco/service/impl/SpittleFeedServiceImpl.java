package com.hef.marco.service.impl;

import com.hef.marco.domain.Spittle;
import com.hef.marco.service.SpittleFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
@Service
public class SpittleFeedServiceImpl implements SpittleFeedService {

    @Autowired
    private SimpMessageSendingOperations messaging;


    @Override
    public void broadcastSpittle(Spittle spittle) {
        messaging.convertAndSend("/topic/spittlefeed", spittle);
    }
}
