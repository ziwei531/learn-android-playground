package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class DatePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        setTitle("Date Picker");
    }

    public void handleTimePicker(View view) {
        TextView display = (TextView) view;
        String amPm;

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        if (calendar.get(Calendar.AM_PM) == Calendar.AM) {
            amPm = "AM";
        } else {
            amPm = "PM";
        }

        // Create a new TimePickerDialog and show it
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // Update the EditText with the selected time


                String formattedTime = String.format("%02d:%02d", hourOfDay, minute);
                display.setText(formattedTime + " "+ amPm);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

}