package com.hef.design06;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class TurkeyAdapter implements Duck{

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
