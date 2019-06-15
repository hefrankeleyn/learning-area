package com.hef.design11.factory;

import com.hef.design11.Quackable;
import com.hef.design11.dacks.DuckCall;
import com.hef.design11.dacks.MallardDuck;
import com.hef.design11.dacks.RedheadDuck;
import com.hef.design11.dacks.RubberDuck;
import com.hef.design11.decorators.QuackCounter;

/**
 * @Date 2019-06-14
 * @Author lifei
 */
public class CountingDuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
