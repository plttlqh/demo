package com.example.pattern.observe;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    Observable observable;
    private List<Float> allTemperature = new ArrayList<>();
    private float avgTemperature;
    private float maxTemperature;
    private float minTemperate;

    public StatisticsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min tempature = " + avgTemperature +"/" + maxTemperature +"/" + minTemperate +"/");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            allTemperature.add(weatherData.getTemperature());
            calculateTemperature();
            display();
        }
    }

    private void calculateTemperature() {
        max();
        min();
        avg();
    }

    private void avg() {
        float sum = 0;
        for (int i = 0; i < allTemperature.size(); i++) {
            sum += allTemperature.get(i);
        }
        avgTemperature = sum / allTemperature.size();
    }

    private void min() {
        float max = allTemperature.get(0);
        for (int i = 1; i < allTemperature.size(); i++) {
            if (allTemperature.get(i)>max){
                max = allTemperature.get(i);
            }
        }
        minTemperate = max;
    }

    private void max() {
        float min = allTemperature.get(0);
        for (int i = 1; i < allTemperature.size(); i++) {
            if (allTemperature.get(i)<min){
                min = allTemperature.get(i);
            }
        }
        maxTemperature = min;
    }
}
