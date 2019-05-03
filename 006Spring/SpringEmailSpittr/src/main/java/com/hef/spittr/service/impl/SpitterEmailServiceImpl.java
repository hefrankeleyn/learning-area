package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Service
public class SpitterEmailServiceImpl implements SpitterEmailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;
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

    @Override
    public void sendSpittleEmailWithAttachment(Spitter spitter) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper =
                null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("frankeleyn@163.com");
            helper.setTo(spitter.getEmail());
            helper.setSubject("New Spitter from :" + spitter.getFullName());
            helper.setText("Please look bogs");
            // 添加附件
            ClassPathResource sanImage = new ClassPathResource("/photos/san.jpg");
            helper.addAttachment("san.jpg", sanImage);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
}
