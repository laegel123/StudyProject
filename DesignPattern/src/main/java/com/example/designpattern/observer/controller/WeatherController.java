package com.example.designpattern.observer.controller;

import com.example.designpattern.observer.entity.CurrentConditionDisplay;
import com.example.designpattern.observer.entity.WeatherData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/currentWeather")
    public ResponseEntity<String> currentWeather() {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);


        return ResponseEntity.ok("test");
    }
}
