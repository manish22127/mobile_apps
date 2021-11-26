package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Calendar cal=Calendar.getInstance();

        ed=findViewById(R.id.ed);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min=cal.get(Calendar.MINUTE);

        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog td = new TimePickerDialog(SecondActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ed.setText(hourOfDay + ":" + minute);
                    }
                },hour,min,false);
                td.show();
            }
        });
    }
}