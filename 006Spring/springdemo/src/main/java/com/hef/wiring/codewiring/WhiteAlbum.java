package com.hef.wiring.codewiring;

public class WhiteAlbum implements CompactDisc {
    private String title = "White. Peppers's love";
    private String artist = "The Album";
    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
