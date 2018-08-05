package com.example.david_chong.reimagined_assistant.weatherdata;

import android.content.Context;
import android.util.Log;

import com.example.david_chong.reimagined_assistant.R;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;

public class WeatherRecognizer implements WeatherSource {
    private static final String TAG = "WWD";
    private static final String URL_FORMAT = "http://api.wunderground.com/api/%s/conditions/q/%s,%s.json";

    private ExecutorService executorService;
    private Context context;

    public WeatherRecognizer(ExecutorService executorService, Context context) {
        this.executorService = executorService;
        this.context = context;
    }

    @Override
    public WeatherDataObject getWeather(LocationDataObject locationDataObject) {
        checkInput(locationDataObject);

        String url = getUrlFromGeolocation(locationDataObject);

        //TODO: Extract Weather Data from URL

        String weather = "cloudy";

        WeatherDataObject weatherDataObject = new WeatherDataObject(BigDecimal.valueOf(0.0), weather, BigDecimal.valueOf(0.0));

        return weatherDataObject;
    }

    private void checkInput(LocationDataObject locationDataObject) {
        if(locationDataObject == null){
            throw new NullPointerException("Null Location DTO");
        }
        else if(locationDataObject.getLatitude() == null){
            throw new IllegalStateException("Null Latitude in location dto");
        }
        else if(locationDataObject.getLongitude() == null){
            throw new IllegalStateException("Null Longitude in location dto");
        }
    }

    private String getUrlFromGeolocation(LocationDataObject locationDataObject){
        String apiKey = context.getString(R.string.wunderground_api_key);
        String latitude = locationDataObject.getLatitude().toPlainString();
        String longitude = locationDataObject.getLongitude().toPlainString();

        String url = String.format(URL_FORMAT, apiKey, latitude, longitude);

        Log.d(TAG, url);
        return url;
    }

    @Override
    public void callbackInterpret(final LocationDataObject locationDataObject, final WeatherCallback weatherCallback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                WeatherDataObject weatherDataObject = getWeather(locationDataObject);

                if(weatherCallback != null){
                    weatherCallback.recieveCallback(weatherDataObject);
                }
            }
        };

        this.executorService.submit(runnable);
    }
}
