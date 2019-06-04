package com.hef.design05.store;

/**
 * 点灯
 */
public class Light {

    private String roomWhich;

    public Light(String roomWhich) {
        this.roomWhich = roomWhich;
    }

    public Light() {
        roomWhich="";
    }

    public void on(){
        System.out.println(roomWhich + " light on...");
    }

    public void off(){
        System.out.println(roomWhich + " light off..");
    }
}
