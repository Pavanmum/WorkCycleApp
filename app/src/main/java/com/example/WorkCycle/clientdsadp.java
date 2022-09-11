package com.example.WorkCycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class clientdsadp extends RecyclerView.Adapter<clientdsadp.MyViewholder> {

    Context context;
    ArrayList<acccept> usersArrayList;
    EditText name,note,email;
    Button button;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    public clientdsadp(Context context, ArrayList<acccept> usersArrayList) {
        this.usersArrayList = usersArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public clientdsadp.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.clientd,parent,false);

        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull clientdsadp.MyViewholder holder, int position) {
        acccept user = usersArrayList.get(position);

        holder.Name.setText(user.getName());
        holder.Note.setText(user.getEmail());
        holder.Work.setText(user.getMobile());

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {

        TextView Name,Note,Work;
        CardView cv;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.eventname);
            Work = itemView.findViewById(R.id.name);
            Note = itemView.findViewById(R.id.note);
            cv = itemView.findViewById(R.id.cards);
        }
    }
}
