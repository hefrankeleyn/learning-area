package com.hef.design03;

/**
 * 调料
 * 必须让 CondimentDecorator 能够取代Beverage， 所以将 CondimentDecorator 拓展自 Beverage 类
 * @Date 2019-05-29
 * @Author lifei
 */
public abstract class CondimentDecorator extends Beverage{

    /**
     * 所有调料装饰者都必须重新实现 getDescription() 方法
     * @return
     */
    public abstract String getDescription();
}
