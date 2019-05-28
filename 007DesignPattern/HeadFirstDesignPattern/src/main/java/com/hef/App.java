package com.hef;

import com.hef.design01.Duck;
import com.hef.design01.MallardDuck;
import com.hef.design01.behaviors.impl.FlyNoWay;
import com.hef.design02.WeatherData;
import com.hef.design02.ramas.CurrentConditionsDisplay;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        strategyPattern();

        observerPattern();
    }


    /**
     * 观察者模式
     */
    private static void observerPattern(){
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay =
                new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasureMents(80.0f, 65f, 30.4f);
    }


    /**
     * 策略设计模式
     */
    private static void strategyPattern(){
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
        duck.setFlyBehavior(new FlyNoWay());
        duck.performFly();
    }
}
