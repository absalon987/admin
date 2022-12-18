package com.example.adminappsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Delivered, Pending, Archive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Delivered = (Button)findViewById(R.id.btndelivered);
        Delivered.setOnClickListener(this);

        Pending = (Button)findViewById(R.id.btnpending);
        Pending.setOnClickListener(this);

        Archive = (Button)findViewById(R.id.btnarchive);
        Archive.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btndelivered):
                startActivity(new Intent(MainActivity.this, delivered.class));
                break;
            case (R.id.btnpending):
                startActivity(new Intent(MainActivity.this, pending.class));
                break;
            case (R.id.btnarchive):
                startActivity(new Intent(MainActivity.this, archive.class));
                break;
        }

    }
}



