package com.example.david_chong.reimagined_assistant.weatherdata;

import java.math.BigDecimal;

public class LocationDataObject {
    private BigDecimal latitude;
    private BigDecimal longitude;

    public LocationDataObject(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        String str = String.format("lat:%s, lng:%s", latitude.toPlainString(), longitude.toPlainString());
        return str;
    }
}
