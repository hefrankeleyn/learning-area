package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Service
public class SpitterEmailServiceImpl implements SpitterEmailService {

    @Autowired
    private MailSender mailSender;
    @Override
    public void sendSimpleSpittleEmail(Spitter spitter) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String spitterName = spitter.getFullName();
        mailMessage.setFrom("frankeleyn@163.com");
        mailMessage.setTo(spitter.getEmail());
        mailMessage.setSubject("Hello spitter : " + spitterName);

        // 设置消息文本
        mailMessage.setText("I have a dream.");

        // 发送 Email
        mailSender.send(mailMessage);
    }
}
