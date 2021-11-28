package com.example.lab5demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rate extends AppCompatActivity {
    RatingBar rate;
    Button b1;
    ConstraintLayout constraintLayout;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                constraintLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.green:
                constraintLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.yellow:
                constraintLayout.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        constraintLayout=findViewById(R.id.cl);

        b1=findViewById(R.id.click);
        rate=findViewById(R.id.ratingBar);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String max= ""+rate.getNumStars();
                String val=""+rate.getRating();

               Toast.makeText(getApplicationContext(),"Max ="+max+"\nSelected ="+val,Toast.LENGTH_LONG).show();
            }


        });


    }
}