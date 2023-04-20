package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelfStudyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_study_page);
        setTitle("Self Study Page");
    }

    public void navigateListViewPractice(View view) {
        Intent i = new Intent(this, ListViewPractice.class);
        startActivity(i);
    }

    public void navigateRecyclerViewPractice(View view) {
        Intent i = new Intent(this, RecycleView.class);
        startActivity(i);
    }
}