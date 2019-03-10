package com.hef.wiring.multi04;

import com.hef.wiring.automic.MediaPlayer;
import com.hef.wiring.xmlwiring.CompactDisc;


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
