package com.hef.wiring.xmlwiring;

import com.hef.wiring.automic.CompactDisc;

import java.util.List;

public class MultiDisc implements CompactDisc {


    private String title;
    private String artist;
    private List<String> tracks;
    public MultiDisc(String title, String artist,List<String> tracks){
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }
    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track:" + track);
        }
    }
}
