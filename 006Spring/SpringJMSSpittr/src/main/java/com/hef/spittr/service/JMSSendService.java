package com.hef.spittr.service;

public interface JMSSendService {

    /**
     *  使用传统的方式发送消息
     * @param message
     */
    void sendMessage(String message);
}
