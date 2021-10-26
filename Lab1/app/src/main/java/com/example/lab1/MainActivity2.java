package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        //String value1 = super.getIntent()getExtras().getString("message");
        String value1=super.getIntent().getExtras().getString("mesage");
        TextView tv = findViewById(R.id.textView3);
        tv.setText(value1);


    }
}