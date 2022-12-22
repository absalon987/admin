package com.example.adminappsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMessage extends AppCompatActivity {

    TextView ticketNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        Intent intent = getIntent();
        String key = intent.getStringExtra("keyID");


        ticketNumber = (TextView)findViewById(R.id.ticketNumberID);

        ticketNumber.setText(key);
        System.out.println(key);


    }
}