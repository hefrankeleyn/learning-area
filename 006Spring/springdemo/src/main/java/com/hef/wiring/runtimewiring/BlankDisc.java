package com.hef.wiring.runtimewiring;

import com.hef.wiring.xmlwiring.CompactDisc;

public class BlankDisc implements CompactDisc {

    private String title;
    private String article;

    public BlankDisc(String title, String article){
        this.title = title;
        this.article = article;
    }


    @Override
    public void play() {
        System.out.println(title+", "+article);
    }
}
