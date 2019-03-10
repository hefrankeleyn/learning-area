package com.hef.wiring.xmlproperty;

import com.hef.wiring.automic.MediaPlayer;


public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;


    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }
    @Override
    public void play() {
        compactDisc.play();
    }
}
