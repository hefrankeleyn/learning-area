package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;
import config.RootConfig;
import config.WebAppInitializer;
import config.WebConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
public class SpitterEmailServiceTest {

    @Autowired
    private SpitterEmailService spitterEmailService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterEmailService);
    }

    /**
     * 发送普通文本
     */
    @Test
    public void sendEmailTest(){
        Spitter spitter = new Spitter("Xiao xi", "xiao", "password",
                "hefrankeleyn@gmail.com", true);
        spitterEmailService.sendSimpleSpittleEmail(spitter);
    }

    /**
     * 发送附件
     */
    @Test
    public void sendAttachmentMailTest(){
        Spitter spitter = new Spitter("Xiao xi", "xiao", "password",
                "hefrankeleyn@163.com", true);
        spitterEmailService.sendSpittleEmailWithAttachment(spitter);
    }

    @Test
    public void sendHtmlMailTest(){
        Spitter spitter = new Spitter("Xiao xi", "xiao", "password",
                "hefrankeleyn@gmail.com", true);
        spitterEmailService.sendHtmlEmail(spitter);
    }

    /**
     * 使用Thymeleaf模板
     */
    @Test
    public void sendHtmlThymeleafEmailTest(){
        Spitter spitter = new Spitter("Xiao xi", "xiao", "password",
                "hefrankeleyn@gmail.com", true);
        spitterEmailService.sendHtmlThymeleafEmail(spitter);
    }
}
