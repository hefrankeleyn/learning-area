package com.hef.design11.factory;

import com.hef.design11.Quackable;

/**
 * @Date 2019-06-14
 * @Author lifei
 */
public abstract class AbstractDuckFactory {

    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();

}
