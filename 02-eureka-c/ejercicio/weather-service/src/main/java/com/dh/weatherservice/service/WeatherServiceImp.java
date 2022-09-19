package com.dh.weatherservice.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImp implements WeatherService {

    @Override
    public Integer getTemperature(String city, String country) {
        return 30;
    }
}
