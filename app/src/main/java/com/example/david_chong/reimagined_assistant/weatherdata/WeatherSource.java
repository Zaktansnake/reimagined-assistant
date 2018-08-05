package com.example.david_chong.reimagined_assistant.weatherdata;

public interface WeatherSource {
    WeatherDataObject getWeather(LocationDataObject locationDataObject);
    void callbackInterpret(LocationDataObject locationDataObject, WeatherCallback weatherCallback);
}
