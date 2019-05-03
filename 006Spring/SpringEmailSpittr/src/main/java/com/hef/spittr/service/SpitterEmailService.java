package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

import javax.mail.MessagingException;

public interface SpitterEmailService {

    /**
     * 发送简单的文本
     * @param spitter
     */
    void sendSimpleSpittleEmail(Spitter spitter);

    /**
     * 发送附件
     * @param spitter
     */
    void sendSpittleEmailWithAttachment(Spitter spitter);


    /**
     * 发送html
     * @param spitter
     */
    void sendHtmlEmail(Spitter spitter);

    /**
     * 使用Velocity 发送富文本
     * @param spitter
     */
    void sendHtmlVelocityEmail(Spitter spitter);

    /**
     * 使用Thymeleaf 构建Email消息
     * @param spitter
     */
    void sendHtmlThymeleafEmail(Spitter spitter);
}
