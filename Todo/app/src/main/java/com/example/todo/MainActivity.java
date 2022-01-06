package com.example.todo;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements action_fragment.FragmentListener {
    action_fragment action_fragment;
    List_fragment list_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        action_fragment=new action_fragment();
        list_fragment=new List_fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, list_fragment)
                .replace(R.id.frameLayout2, action_fragment)
                .commit();
    }

    @Override
    public void action_input(String name,String operation) {
        list_fragment.update(name, operation);

    }





}