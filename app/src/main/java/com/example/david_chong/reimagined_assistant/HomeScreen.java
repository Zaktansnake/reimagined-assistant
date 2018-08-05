package com.example.david_chong.reimagined_assistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.david_chong.reimagined_assistant.viewmodel.ViewModel;

import java.math.BigDecimal;

public class HomeScreen extends AppCompatActivity {

    private boolean currentLocationWeather;

    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        this.viewModel = new ViewModel();
        this.currentLocationWeather = false;
    }
}
