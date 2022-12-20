package com.example.adminappsender;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<Messages> msgList;


    public Adapter(Context context, ArrayList<Messages> msgList) {
        this.context = context;
        this.msgList = msgList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.design1, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Messages msgs = msgList.get(position);
        holder.subject.setText(msgs.getSubject());
        holder.key.setText(msgs.getKey());


    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


    public static class MyViewHolder extends ViewHolder implements View.OnClickListener {

        TextView senderNumber;
        Button subject;
        TextView key;
        String keyID;
        Activity activity;
        Context context;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.subject);
            key = itemView.findViewById(R.id.ticketNumber);
//            keyID = key.getAutofillValue().toString();


            subject.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(subject.getContext(), ViewMessage.class);
            subject.getContext().startActivity(intent);
//            intent.putExtra("keyValue", keyID);


        }
    }
}

