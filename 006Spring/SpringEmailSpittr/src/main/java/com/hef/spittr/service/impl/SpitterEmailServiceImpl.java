package com.hef.spittr.service.impl;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterEmailService;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Service
public class SpitterEmailServiceImpl implements SpitterEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // 自动装配velocityEngine
    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private TemplateEngine templateEngine;


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
        javaMailSender.send(mailMessage);
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

    /**
     * 发送富文本
     * @param spitter
     */
    @Override
    public void sendHtmlEmail(Spitter spitter) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try{
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("frankeleyn@163.com");
            helper.setTo(spitter.getEmail());
            helper.setSubject("Html text from: " + spitter.getFullName());
            // 发送富文本
            helper.setText("<html><body><img src='cid:spitterLogo'/><h4>"+spitter.getFullName()+" says...</h4><i>I have a dream.</i></body></html>",true);

            ClassPathResource sanImage = new ClassPathResource("/photos/san.jpg");
            helper.addInline("spitterLogo", sanImage);
            javaMailSender.send(message);
        }catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendHtmlVelocityEmail(Spitter spitter) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try{
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("frankeleyn@163.com");
            helper.setTo(spitter.getEmail());
            helper.setSubject("Html text from: " + spitter.getFullName());
            // 发送富文本
            helper.setText(generateHtmlStr(spitter), true);
            ClassPathResource sanImage = new ClassPathResource("/photos/san.jpg");
            helper.addInline("spitterLogo", sanImage);
            javaMailSender.send(message);
        }catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendHtmlThymeleafEmail(Spitter spitter) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try{
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("frankeleyn@163.com");
            helper.setTo(spitter.getEmail());
            helper.setSubject("Html text from: " + spitter.getFullName());
            // 发送富文本
            helper.setText(generateThymeaf(spitter), true);
            ClassPathResource sanImage = new ClassPathResource("/photos/san.jpg");
            helper.addInline("spitterLogo", sanImage);
            javaMailSender.send(message);
        }catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用Thymeleaf
     * @param spitter
     * @return
     */
    private String generateThymeaf(Spitter spitter){
        Context context = new Context();
        context.setVariable("spitterName", spitter.getFullName());
        context.setVariable("spittleText", "I have a dream");
        return templateEngine.process("emailHello.html", context);
    }
    /**
     * 使用Veocity 生成模板
     * @param spitter
     * @return
     */
    private String generateHtmlStr(Spitter spitter){
        Map<String, String> model = new HashMap<>();
        model.put("spitterName", spitter.getFullName());
        model.put("spitterText", "I use velocity send emial.");
        String emilText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "emailTemplate.vm", model);
        return emilText;
    }

}
