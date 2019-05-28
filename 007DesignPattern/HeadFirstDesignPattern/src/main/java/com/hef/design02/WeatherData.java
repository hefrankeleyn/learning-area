package com.hef.design02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019-05-28
 * @Author lifei
 */
public class WeatherData implements Subject{

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o :
                observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void measuermentsChanged(){
        notifyObserver();
    }

    public void setMeasureMents(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measuermentsChanged();
    }
}
