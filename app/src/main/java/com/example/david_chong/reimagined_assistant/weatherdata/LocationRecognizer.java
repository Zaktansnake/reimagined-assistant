package com.example.david_chong.reimagined_assistant.weatherdata;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;

public class LocationRecognizer implements LocationSource {
    private static final String TAG = "GLD";

    private ExecutorService executorService;
    private Context context;

    public LocationRecognizer(ExecutorService executorService, Context context) {
        this.executorService = executorService;
        this.context = context;
    }

    @Override
    public LocationDataObject getLocation() {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String locationProvider = locationManager.getBestProvider(criteria, false);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            throw new RuntimeException("No Access Permission");
        }

        Location location = locationManager.getLastKnownLocation(locationProvider);
        if(location == null){
            Log.w(TAG, "Location is Null");
            return null;
        }

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        LocationDataObject locationDataObject = new LocationDataObject(BigDecimal.valueOf(latitude), BigDecimal.valueOf(longitude));

        Log.d(TAG, locationDataObject.toString());
        return locationDataObject;
    }

    @Override
    public void callbackInterpret(final LocationCallback locationCallback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                LocationDataObject locationDataObject = getLocation();

                if(locationCallback != null){
                    locationCallback.recieveCallback(locationDataObject);
                }
            }
        };

        this.executorService.submit(runnable);
    }
}
