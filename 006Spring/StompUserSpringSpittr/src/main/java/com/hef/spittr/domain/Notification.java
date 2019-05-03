package com.hef.spittr.domain;

/**
 * @Date 2019-05-02
 * @Author lifei
 */
public class Notification {

    private String message;

    public Notification() {
    }

    public Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
