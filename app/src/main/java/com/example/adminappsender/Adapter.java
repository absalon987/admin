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

    private Context context;
    private ArrayList<Messages> msgList;


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

        Messages messages = msgList.get(position);
        holder.subject.setText(messages.getSubject());
        holder.key.setText(messages.getKey());
        holder.message.setText(messages.getMessage());



        holder.subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String key = holder.key.getText().toString();
                String subject = holder.subject.getText().toString();
                String message = holder.message.getText().toString();

                Intent intent = new Intent(context, ViewMessage.class);
                intent.putExtra("keyID", key);
                intent.putExtra("subjectID",subject);
                intent.putExtra("messageID",message);
                context.startActivity(intent);
                System.out.println(key);
            }
        });

    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


    public static class MyViewHolder extends ViewHolder {


        Button subject;
        TextView key ;
        TextView message;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.subject);
            key = itemView.findViewById(R.id.ticketNumber);
            message = itemView.findViewById(R.id.mainMessage);



        }
    }
}

