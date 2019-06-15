package com.hef.design11;

import com.hef.design11.observer.QuackObservable;

/**
 * @Date 2019-06-14
 * @Author lifei
 */
public interface Quackable extends QuackObservable {

    // 呱呱叫
    void quack();
}
