package com.example.david_chong.reimagined_assistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import com.example.david_chong.reimagined_assistant.viewmodel.ViewModel;

public class HomeScreen extends AppCompatActivity {
    private static final String TAG = "HS";

    private ViewModel viewModel;

    private Button speechBtn;
    private TextView speechOutput;
    private TextView location;
    private TextView weather;
    private TextView temperature;
    private TextView windSpeed;

    //TODO: Add Speech Interpreter to HomeScreen
    //TODO: Add Weather Data Caller to HomeScreen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        setupUI();

        this.viewModel = new ViewModel();
    }

    private void setupUI() {
        this.speechBtn = (Button) findViewById(R.id.speechBtn);
        this.speechOutput = (TextView) findViewById(R.id.speechOutput);
        this.location = (TextView) findViewById(R.id.location);
        this.weather = (TextView) findViewById(R.id.weather);
        this.temperature = (TextView) findViewById(R.id.temperature);
        this.windSpeed = (TextView) findViewById(R.id.windSpeed);

        this.speechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Add Listener method to interpret speech
            }
        });
    }

}
