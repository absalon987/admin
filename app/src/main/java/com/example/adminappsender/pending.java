package com.example.adminappsender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class pending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pending);
    }
}