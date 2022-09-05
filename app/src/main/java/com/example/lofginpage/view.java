package com.example.lofginpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lofginpage.ui.User;

import java.util.ArrayList;

public class view extends RecyclerView.Adapter<view.MyViewHolder> {

    ArrayList<User> list;
    Context context;

        public view(ArrayList<User> list,Context context) {


    }

    public view(ArrayList<User> lists) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adminview,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.Name.setText(user.getName());
        holder.age.setText(user.getAge());
        holder.mail.setText(user.getEmail());
        holder.qua.setText(user.getQualification());
        holder.exp.setText(user.getExperience());
        holder.mob.setText(user.getMobile());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name, age, exp, qua, mail, mob;

        CardView cv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.t1);
            age = itemView.findViewById(R.id.t2);
            exp = itemView.findViewById(R.id.t3);
            qua = itemView.findViewById(R.id.t4);
            mail = itemView.findViewById(R.id.t5);
            mob = itemView.findViewById(R.id.t6);
            cv = itemView.findViewById(R.id.cardView10);
        }
    }
}




