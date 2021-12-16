package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

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

                ParseUser.logInInBackground(uname.getText().toString(), pwd.getText().toString(), (pareUser, e) -> {
                    if (pareUser != null) {
                        Toast.makeText(getApplicationContext(),"Welcome "+uname.getText().toString(),Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this,Second.class);
                        startActivity(i);

                    } else {
                        ParseUser.logOut();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


//                ParseUser user = new ParseUser();
//                // Set the user's username and password, which can be obtained by a forms
//                user.setUsername(uname.getText().toString());
//                user.setPassword(pwd.getText().toString());
//                user.signUpInBackground(new SignUpCallback() {
//                    @Override
//                    public void done(ParseException e) {
//                        if (e == null) {
//                            //showAlert("Successful Sign Up!", "Welcome" + "<Your username here>" +"!");
//                            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
//
//                        } else {
//                            ParseUser.logOut();
//                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });

            }
        });


    }
}