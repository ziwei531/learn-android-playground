package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //you bind activity_main.xml by doing the below
        setContentView(R.layout.activity_main);
        setTitle("Home");
    }

    //this onclick is generalized
    public void submit(View view) {
        Button button = (Button) view;
        EditText editText = findViewById(R.id.editText);
        TextView mainTextView = findViewById(R.id.mainTextView);
        String input = String.valueOf(editText.getText()); //or editText.getText().toString()
        mainTextView.setText(input);
        //alert
        Toast.makeText(this, "Successfully Added " + input, Toast.LENGTH_LONG).show();
    }

    public void handleNavigation(View view) {
        Button button = (Button) view;
        //let's assume the new page is a settings page.
        Intent i = new Intent(this, SettingsPage.class); //necessary for switching to new page
        EditText editText = findViewById(R.id.editText);
        String input = String.valueOf(editText.getText());
        i.putExtra("UserInput", input);
        startActivity(i);
    }

    public void weekThree(View view) {
        Button button = (Button) view;
        Intent i = new Intent(this, Week3.class);
        startActivity(i);
    }

    public void navigateSelfStudyPage(View view) {
        Button button = (Button) view;
        Intent i = new Intent(this, SelfStudyPage.class);
        startActivity(i);
    }


}