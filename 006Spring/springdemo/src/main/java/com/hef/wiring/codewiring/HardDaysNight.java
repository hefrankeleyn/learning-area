package com.hef.wiring.codewiring;

public class HardDaysNight implements CompactDisc{

    private String title = "Hard.. Peppers's love";
    private String artist = "The DaysNight";
    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
