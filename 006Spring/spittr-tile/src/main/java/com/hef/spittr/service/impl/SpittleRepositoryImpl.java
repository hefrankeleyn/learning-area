package com.hef.spittr.service.impl;

import com.hef.spittr.entities.Spittle;
import com.hef.spittr.service.SpittleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return createSpittles(count);
    }

    @Override
    public Spittle findOne(long spittleId) {
        return new Spittle(spittleId, "Spittle" + spittleId, new Date(), 0.0, 0.0);
    }

    private List<Spittle> createSpittles(int count){
        List<Spittle> spittles = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            //spittles.add(new Spittle("Spittle"+i, new Date()));
            spittles.add(new Spittle(Long.parseLong(i+""),"Spittle" + i, new Date(), 0.0, 0.0));
        }
        return spittles;
    }
}
