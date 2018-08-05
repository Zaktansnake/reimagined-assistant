package com.example.david_chong.reimagined_assistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;

import com.example.david_chong.reimagined_assistant.R;

import com.example.david_chong.reimagined_assistant.viewmodel.ViewModel;

import com.example.david_chong.reimagined_assistant.speech.SpeechDataObject;
import com.example.david_chong.reimagined_assistant.speech.SpeechInterpretor;
import com.example.david_chong.reimagined_assistant.speech.SpeechCallback;
import com.example.david_chong.reimagined_assistant.speech.APIAIRecognizer;

import java.math.BigDecimal;
import java.util.List;


public class HomeScreen extends AppCompatActivity {

    private boolean currentLocationWeather;

    private ViewModel viewModel;

    //TODO: Add Speech Interpretor to HomeScreen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        this.viewModel = new ViewModel();
        this.currentLocationWeather = false;
    }
}
