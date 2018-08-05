package com.example.david_chong.reimagined_assistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.david_chong.reimagined_assistant.R;

import com.example.david_chong.reimagined_assistant.viewmodel.ViewModel;

import com.example.david_chong.reimagined_assistant.speech.SpeechDataObject;
import com.example.david_chong.reimagined_assistant.speech.SpeechInterpretor;
import com.example.david_chong.reimagined_assistant.speech.SpeechCallback;
import com.example.david_chong.reimagined_assistant.speech.APIAIRecognizer;


public class HomeScreen extends AppCompatActivity {

    private boolean currentLocationWeather;

    private ViewModel viewModel;

    //TODO: Add Speech Interpretor to HomeScreen
    //TODO: Add Weather Data Caller to HomeScreen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        this.viewModel = new ViewModel();
        this.currentLocationWeather = false;
    }
}
