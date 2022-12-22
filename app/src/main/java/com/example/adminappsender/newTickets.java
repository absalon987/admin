package com.example.adminappsender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class newTickets extends AppCompatActivity {

    ArrayList<Messages> listMsgs;
    Adapter myAdapter;
    RecyclerView recyclerView;
    private DatabaseReference reference, reference1, reference2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.inbox_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        reference = FirebaseDatabase.getInstance().getReference("Delivered Tickets");
        reference1 = reference.child("category");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listMsgs = new ArrayList();
        myAdapter = new Adapter(this, listMsgs);
        recyclerView.setAdapter(myAdapter);
        reference.addValueEventListener(new ValueEventListener(){


            public void onDataChange(DataSnapshot snapshot) {


                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                    Messages msgs = dataSnapshot.getValue(Messages.class);
                    String cat = reference1.toString();
//                    if (cat.toString() == "Connection") {

                    listMsgs.add(msgs);

//                    }
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}