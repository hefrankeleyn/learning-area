package com.hef.spittr.service;

import com.hef.spittr.domain.Spitter;

import java.util.List;

public interface SpittleService {

    /**
     * 根据id获取 Spitter
     * @param id
     * @return
     */
    Spitter findSpitterById(long id);

    /**
     * 获取所有的Spitter
     * @return
     */
    List<Spitter> getAllSpitter();

    /**
     * 保存Spitter
     * @return
     */
    Spitter saveSpitter(Spitter spitter);
}
