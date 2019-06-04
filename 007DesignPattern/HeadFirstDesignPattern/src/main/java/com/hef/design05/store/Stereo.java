package com.hef.design05.store;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class Stereo {

    private String description;

    public Stereo(String description) {
        this.description = description;
    }

    public Stereo() {
        description = "";
    }

    public void on(){
        System.out.println(description + " Stereo on...");
    }

    public void setCD(){
        System.out.println(description + " Stereo set CD...");
    }

    public void setVolume(int num){
        System.out.println(description + " Stereo set Volume is " + num);
    }

    public void off(){
        System.out.println(description + " stereo set off..");
    }
}
