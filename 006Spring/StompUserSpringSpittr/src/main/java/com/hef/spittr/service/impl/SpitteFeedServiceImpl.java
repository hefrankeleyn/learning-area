package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Notification;
import com.hef.spittr.domain.Spittle;
import com.hef.spittr.service.SpittleFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date 2019-05-03
 * @Author lifei
 */

@Service
public class SpitteFeedServiceImpl implements SpittleFeedService {

    @Autowired
    private SimpMessageSendingOperations messaging;

    // 匹配用户的名字
    private Pattern pattern = Pattern.compile("\\@(\\S+)");


    @Override
    public void broadcastSpittle(Spittle spittle) {
        messaging.convertAndSend("/topic/spittlefeed", spittle);

        Matcher matcher = pattern.matcher(spittle.getMessage());
        if(matcher.find()){
            String username = matcher.group(1);
            messaging.convertAndSendToUser(username,
                    "/queue/notifications", new Notification("You juest got mentioned!"));
        }
    }
}
