package com.example.sample_lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    ImageButton imgbtn;
    Switch swtch;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtn= findViewById(R.id.imageButton);
        swtch = findViewById(R.id.switch1);
        cl = findViewById(R.id.layout);

        DatePicker dt = new DatePicker(this);
        cl.addView(dt);
        imgbtn.setEnabled(false);



        swtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    imgbtn.setEnabled(true);
                }
                else
                {
                    imgbtn.setEnabled(false);
                }
            }
        });
    }
}