package com.hef.spittr.service.impl;

import com.hef.spittr.entities.Spitter;
import com.hef.spittr.service.SpitterRepository;
import org.springframework.stereotype.Component;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        if (spitter.getsId() == null ){
            spitter.setsId(Long.parseLong(((int)Math.random()*30*2) +""));
        }
        System.out.println("Save OK! "+spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        Spitter spitter = new Spitter(23L,username,"23xiao","Wang","Ming");
        return spitter;
    }
}
