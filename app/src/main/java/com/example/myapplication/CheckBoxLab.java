package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class CheckBoxLab extends AppCompatActivity {
    private static final String TAG = "CheckBoxLab";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_lab);
        setTitle("CheckBox Lab");

    }

    public void submit(View view) {
        Button button = (Button) view;
        TextView display = findViewById(R.id.display);
        final CheckBox cbSelangor, cbMelaka, cbSabah;

        cbSelangor = findViewById(R.id.checkBox_selangor);
        cbMelaka = findViewById(R.id.checkBox_melaka);
        cbSabah = findViewById(R.id.checkBox_sabah);

        final String[] str = {""};

        if (cbSelangor.isChecked()) {
            Log.d(TAG, "Selangor is checked");
            str[0] += "Selangor ";
        }
        else {
            str[0] = str[0].replace("Selangor ", "");
        }

        if (cbMelaka.isChecked()) {
            Log.d(TAG, "Melaka is Checked");
            str[0] += "Melaka ";
        }
        else {
            str[0] = str[0].replace("Melaka ", "");
        }

        if(cbSabah.isChecked()) {
            Log.d(TAG, "Sabah is Checked");
            str[0] += "Sabah ";
        }
        else {
            str[0] = str[0].replace("Sabah ", "");
        }

        display.setText(str[0]);

        if (cbSabah.isChecked() == false && cbMelaka.isChecked() == false && cbSelangor.isChecked() == false) {
            display.setText("No Values Are Selected Yet");
        }
    }


}