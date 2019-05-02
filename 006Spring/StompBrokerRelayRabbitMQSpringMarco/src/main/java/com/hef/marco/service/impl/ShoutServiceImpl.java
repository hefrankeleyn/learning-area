package com.hef.marco.service.impl;

import com.hef.marco.domain.Shout;
import com.hef.marco.service.ShoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

/**
 * @Date 2019-05-02
 * @Author lifei
 */
@Service
public class ShoutServiceImpl implements ShoutService {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;
    @Override
    public void shoutStr() {
        Shout shout = new Shout();

        shout.setMessage("shout:" + Math.random());
        simpMessageSendingOperations.convertAndSend("/topic/shout", shout);
    }
}
