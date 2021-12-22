package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    ImageButton i;
    Switch s;
    ConstraintLayout c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.imageButton);
        s=findViewById(R.id.switch1);
        c=findViewById(R.id.c1);


        DatePicker d=new DatePicker(this);
        boolean bool=true;
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    i.setEnabled(true);
                    c.addView(d);
                }
                else{
                    i.setEnabled(false);
                    c.removeView(d);
                }
            }
        });


    }
}