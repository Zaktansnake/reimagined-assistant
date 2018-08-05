package com.example.david_chong.reimagined_assistant.viewmodel;

import java.math.BigDecimal;

public class ViewModel {
    private String query;
    private String location;
    private String weather;
    private BigDecimal temperature;

    public ViewModel() {
        query = "";
        location = "";
        weather = "";
        temperature = BigDecimal.ZERO;
    }

    public void reset(){
        query = "";
        location = "";
        weather = "";
        temperature = BigDecimal.ZERO;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }
}
