package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Week3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3);
        setTitle("Week 3");
    }

    public void navigateToSum(View view) {
        Button button = (Button) view;
        Intent i = new Intent(this, Sum.class);
        startActivity(i);
    }
}