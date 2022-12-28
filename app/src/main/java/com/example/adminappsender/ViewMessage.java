package com.example.adminappsender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ViewMessage extends AppCompatActivity {



    TextView ticketNumber, subs, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        Intent intent = getIntent();
        String key = intent.getStringExtra("keyID");
        String subject = intent.getStringExtra("subjectID");
        String messages = intent.getStringExtra("messageID");

        msg = (TextView) findViewById(R.id.tvmessage);
        subs = (TextView) findViewById(R.id.tvsubject);
        ticketNumber = (TextView) findViewById(R.id.ticketNumberID);


        msg.setText(messages);
        System.out.println(messages);
        subs.setText(subject);
        System.out.println(subject);
        ticketNumber.setText(key);
        System.out.println(key);
    }


}