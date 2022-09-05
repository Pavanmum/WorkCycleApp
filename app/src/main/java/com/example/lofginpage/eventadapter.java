package com.example.lofginpage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class eventadapter extends RecyclerView.Adapter<eventadapter.Eventviewad> {
    ArrayList<Event> list;

    public eventadapter(ArrayList<Event> list, Context context) {
        this.list = list;
    }

    @NonNull
    @Override
    public Eventviewad onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventlayout,parent,false);
        return new Eventviewad(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Eventviewad holder, int position) {

        Event item = list.get(position);
        holder.name.setText(item.getName());
        holder.work.setText(item.getWork());
        holder.days.setText(item.getDays());
        holder.people.setText(item.getPerson());
        holder.location.setText(item.getLocation());
        holder.money.setText(item.getMoney());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.cardView.getContext(),clientdata.class);
                holder.cardView.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Eventviewad extends RecyclerView.ViewHolder {

         TextView name,work,people,days,location,money;
        CardView cardView;


        public Eventviewad(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.eventname);
            work = itemView.findViewById(R.id.eventwork);
            people = itemView.findViewById(R.id.eventpeople);
            days = itemView.findViewById(R.id.eventday);
            location = itemView.findViewById(R.id.eventlocation);
            money = itemView.findViewById(R.id.eventmoney);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
