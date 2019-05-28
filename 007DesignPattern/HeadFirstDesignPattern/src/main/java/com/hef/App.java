package com.hef;

import com.hef.design01.Duck;
import com.hef.design01.MallardDuck;
import com.hef.design01.behaviors.impl.FlyNoWay;
import com.hef.design02.WeatherData;
import com.hef.design02.ramas.CurrentConditionsDisplay;
import com.hef.design02_02.CurrentConditionDisplay;
import com.hef.design02_02.WeatherObservable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        strategyPattern();

//        observerPattern();
        observerPattern02();
    }


    private static void observerPattern02(){
        WeatherObservable observable= new WeatherObservable();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(observable);

        observable.setMeasurements(80f, 70f, 23.2f);
    }
    /**
     * 观察者模式一
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
