package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Sum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        setTitle("Sum of Two Numbers");
    }

    public void sum(View view) {
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        TextView result = findViewById(R.id.result);

        if (
            (num1 == null || num1.getText().toString().isEmpty()) ||
            (num2 == null || num2.getText().toString().isEmpty())
        ) {
            result.setText("Please enter valid inputs!");
            //this is to hide the keyboard after submit
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        else {
            Integer val1 = Integer.parseInt(num1.getText().toString());
            Integer val2 = Integer.parseInt(num2.getText().toString());
            Integer sum = val1 + val2;

            result.setText("Sum of " + val1.toString() + " and " + val2.toString() + " is " + sum.toString());

            //this is to hide the keyboard after submit
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

}