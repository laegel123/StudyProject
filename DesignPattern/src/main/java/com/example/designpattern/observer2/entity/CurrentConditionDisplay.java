package com.example.designpattern.observer2.entity;

public class CurrentConditionDisplay implements Observer, DisplayElement{

    private float temperature;
    private float humidity;
    private float pressure;

    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("온도: ").append(temperature).append("\n");
        sb.append("습도: ").append(humidity).append("\n");
        sb.append("압력: ").append(pressure).append("\n");

    }

    @Override
    public void update() {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
