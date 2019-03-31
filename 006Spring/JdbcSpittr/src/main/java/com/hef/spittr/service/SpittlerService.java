package com.hef.spittr.service;

import com.hef.spittr.entities.Spittler;

public interface SpittlerService {

    void getConnection();

    /**
     * 添加Spittler
     */
    void addSpittler(Spittler spittler);

    /**
     * 更新 Spittler
     * @param spittler
     */
    void updateSpittler(Spittler spittler);

    /**
     * 根据fullname查找 Spittler
     * @param fullname
     * @return
     */
    Spittler findOneSpittler(String fullname);


}
