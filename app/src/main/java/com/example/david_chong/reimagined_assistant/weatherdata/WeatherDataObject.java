package com.example.david_chong.reimagined_assistant.weatherdata;

import java.math.BigDecimal;

public class WeatherDataObject {
    private BigDecimal actualTemperature;
    private String weather;
    private BigDecimal windSpeed;

    public WeatherDataObject(BigDecimal actualTemperature, String weather, BigDecimal windSpeed) {
        this.actualTemperature = actualTemperature;
        this.weather = weather;
        this.windSpeed = windSpeed;
    }

    public BigDecimal getActualTemperature() {
        return actualTemperature;
    }

    public String getWeather() {
        return weather;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    @Override
    public String toString() {
        String str = String.format("%s, %s, %s", weather, actualTemperature.toPlainString(), windSpeed.toPlainString());
        return str;
    }
}
