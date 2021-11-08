package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    First f1;
    Second s1;
    Button b1;
    int current=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);



        f1=new First();
        s1=new Second();


        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.frameLayout,f1);
        ft.commit();

        current=1;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();

                if(current==1){
                    ft.replace(R.id.frameLayout,s1);
                    current=2;
                }
                else
                {
                    ft.replace(R.id.frameLayout,f1);
                    current=1;
                }
                ft.commit();
            }
        });
    }
}