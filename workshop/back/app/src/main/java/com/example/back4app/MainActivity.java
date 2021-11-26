package com.example.back4app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText uname,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login=findViewById(R.id.button);
        uname=findViewById(R.id.un);
        pwd=findViewById(R.id.pw);





        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId(getString(R.string.back4app_app_id))
        .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.logInInBackground(uname.getText().toString(), pwd.getText().toString(), (parseUser, e) -> {
                    if (parseUser != null) {
                        Toast.makeText(getApplicationContext(),"Welcome "+uname.getText().toString(),Toast.LENGTH_LONG).show();
                          Intent i = new Intent(MainActivity.this,Second.class);
                          startActivity(i);

                    } else {
                        ParseUser.logOut();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


    }
}