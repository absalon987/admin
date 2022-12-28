package com.example.adminappsender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewMessage extends AppCompatActivity {

    private TextView ticketNumber, mainMessage;
    DatabaseReference reference;
    private String keyID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        Intent intent = getIntent();
        String key = intent.getStringExtra("keyID");
        keyMessage = FirebaseDatabase.getInstance().getReference().child("key");

        ticketNumber = (TextView)findViewById(R.id.ticketNumberID);
        mainMessage = (TextView)findViewById(R.id.mainMessageTV);

        ticketNumber.setText(key);
        System.out.println(key);


        reference = FirebaseDatabase.getInstance().getReference("Delivered Tickets");
        keyID = reference.getKey();

        reference.child(keyID).addListenerForSingleValueEvent((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Messages messages = snapshot.getValue(Messages.class);

                if (messages != null){
                    String mainMess = messages.message;

                    mainMessage.setText(mainMess);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("adadsadsd");

            }
        }));
    }
}