package com.example.lofginpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class eventadapter extends RecyclerView.Adapter<eventadapter.Eventviewad> {

    Context context;
    ArrayList<Event> list;

    public eventadapter(ArrayList<Event> list, Context context) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Eventviewad onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.eventlayout,parent,false);
        return new Eventviewad(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Eventviewad holder, int position) {

        Event item = list.get(position);
        holder.name.setText(item.getEname());
        holder.work.setText(item.getEwork());
        holder.days.setText(item.getEdays());
        holder.people.setText(item.getEperson());
        holder.location.setText(item.getElocation());
        holder.money.setText(item.getErupees());

//        holder.update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "Update Event", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Eventviewad extends RecyclerView.ViewHolder {

         TextView name,work,people,days,location,money;
         Button update;


        public Eventviewad(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.eventname);
            work = itemView.findViewById(R.id.eventwork);
            people = itemView.findViewById(R.id.eventpeople);
            days = itemView.findViewById(R.id.eventday);
            location = itemView.findViewById(R.id.eventlocation);
            money = itemView.findViewById(R.id.eventmoney);
//            update = itemView.findViewById(R.id.eventimage);

        }
    }
}
