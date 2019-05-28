package com.hef.design02_02;

/**
 * @Date 2019-05-28
 * @Author lifei
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);

    void update(Observable observable, Object arg);

}
