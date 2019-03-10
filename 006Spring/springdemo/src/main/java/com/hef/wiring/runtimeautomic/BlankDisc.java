package com.hef.wiring.runtimeautomic;

import com.hef.wiring.xmlwiring.CompactDisc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlankDisc implements CompactDisc {

    private String title;
    private String article;

    public BlankDisc(@Value("${disc.title}") String title,
                     @Value("${disc.article}") String article){
        this.title = title;
        this.article = article;
    }


    @Override
    public void play() {
        System.out.println(title+", "+article);
    }
}
