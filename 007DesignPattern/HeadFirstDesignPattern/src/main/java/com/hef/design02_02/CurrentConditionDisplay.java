package com.hef.design02_02;


import com.hef.design02.DisplayElement;

/**
 * @Date 2019-05-28
 * @Author lifei
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {

    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherObservable){
            WeatherObservable weatherObservable = (WeatherObservable) observable;
            this.temperature = weatherObservable.getTemperature();
            this.humidity = weatherObservable.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Temperature: " + temperature + ", humidity: " + humidity);
    }
}
