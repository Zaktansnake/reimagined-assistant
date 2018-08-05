package com.example.david_chong.reimagined_assistant.weatherdata;

public interface LocationSource {
    LocationDataObject getLocation();
    void callbackInterpret(LocationCallback locationCallback);
}
