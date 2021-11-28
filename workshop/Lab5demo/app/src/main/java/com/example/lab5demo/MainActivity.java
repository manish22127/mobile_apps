package com.example.lab5demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.login);
        b2=findViewById(R.id.cancel);
        e1=findViewById(R.id.uname);
        e2=findViewById(R.id.pwd);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().equals("manish")&&e2.getText().toString().equals("manish")){
                    Toast.makeText(getApplicationContext(),"Login successfull",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),Dashboard.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login unsuccessfull",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}