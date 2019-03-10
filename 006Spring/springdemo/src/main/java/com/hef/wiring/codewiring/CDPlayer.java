package com.hef.wiring.codewiring;

import com.hef.wiring.automic.MediaPlayer;
import org.springframework.stereotype.Component;


public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}
