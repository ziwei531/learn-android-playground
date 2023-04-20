package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        displayUserInput();
    }

    public void displayUserInput() {
        Intent intent = getIntent();
        String userInput = intent.getStringExtra("UserInput");
        TextView userInputTextView = findViewById(R.id.userInput);
        userInputTextView.setText("The prop value is: " + userInput);
    }
}