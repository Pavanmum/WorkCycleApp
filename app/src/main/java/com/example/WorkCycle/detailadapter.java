package com.example.WorkCycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class detailadapter extends RecyclerView.Adapter<detailadapter.MyViewholder> {

    Context context;
    ArrayList<User> userArrayList;


    public detailadapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public detailadapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.detailsc,parent,false);

        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull detailadapter.MyViewholder holder, int position) {

        User user = userArrayList.get(position);

        holder.Name.setText(user.getName());
        holder.Age.setText(user.getAge());
        holder.Experience.setText(user.getExperience());
        holder.Email.setText(user.getEmail());
        holder.qualification.setText(user.getQualification());
        holder.Mobile.setText(user.getMobile());

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
    public static class MyViewholder extends RecyclerView.ViewHolder{

        TextView Name,Email,Age,Experience,Mobile,qualification;
        CardView cv;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.name);
            Age = itemView.findViewById(R.id.age);
            qualification = itemView.findViewById(R.id.Qualification);
            Experience = itemView.findViewById(R.id.experience);
            Mobile = itemView.findViewById(R.id.mobile);
            Email = itemView.findViewById(R.id.email);
            cv = itemView.findViewById(R.id.cardss);
        }
    }
}
