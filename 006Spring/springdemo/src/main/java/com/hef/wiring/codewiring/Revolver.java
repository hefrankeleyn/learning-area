package com.hef.wiring.codewiring;

public class Revolver implements CompactDisc{

    private String title = "Rev. Peppers's love";
    private String artist = "The Revolver";
    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
