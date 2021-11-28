package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ph,ms;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ph=findViewById(R.id.phone);
        ms=findViewById(R.id.msg);
        send=findViewById(R.id.button);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    SmsManager smg = SmsManager.getDefault();

                    smg.sendTextMessage(ph.getText().toString(), null, ms.getText().toString(), null, null);
                    Toast.makeText(getApplicationContext(),"message sent",Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"message not sent",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}