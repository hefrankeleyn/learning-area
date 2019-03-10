package com.hef.aop.aspect04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        BlankDisc cd = new BlankDisc();
        cd.setTitle("This is blank disc.");
        cd.setArtist("BlankDisc");
        List<String> tracks = new ArrayList<>();
        tracks.add("track01");
        tracks.add("track02");
        tracks.add("track03");
        tracks.add("track04");
        tracks.add("track05");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCount trackCount(){
        return new TrackCount();
    }
}
