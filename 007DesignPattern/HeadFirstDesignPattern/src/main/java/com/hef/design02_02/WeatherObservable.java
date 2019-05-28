package com.hef.design02_02;


/**
 * @Date 2019-05-28
 * @Author lifei
 */
public class WeatherObservable extends Observable{
//    private Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged(){
        super.setChanged();
        super.notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }
}
