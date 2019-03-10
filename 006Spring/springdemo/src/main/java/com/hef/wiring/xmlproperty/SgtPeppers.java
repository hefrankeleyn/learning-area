package com.hef.wiring.xmlproperty;

/*
这个注解会告知spring，为这个类创建bean，没有必要显式配置 sgtPeppers
 */

public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Peppers's Lonely Hearts Club Band.";
    private String artist = "The Beatles";
    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
