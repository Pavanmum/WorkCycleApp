package com.example.WorkCycle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class detailadapter extends RecyclerView.Adapter<detailadapter.MyViewholder> {

    Context context;
    ArrayList<User> userArrayList;
    EditText etName,eAge,etMail,EExp,emobile,notes;
    Button button;
//    FirebaseFirestore db;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

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


        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog d = new Dialog(holder.cv.getContext());
                d.setContentView(R.layout.dialog);
//                d.setCancelable(true);
                etName = d.findViewById(R.id.Name);
                eAge = d.findViewById(R.id.Work);
                etMail = d.findViewById(R.id.days);
                EExp = d.findViewById(R.id.money);
                emobile = d.findViewById(R.id.person);
                button = d.findViewById(R.id.btn);
                notes = d.findViewById(R.id.location);

                etName.setText(user.getName());
                eAge.setText(user.getAge());
                emobile.setText(user.getMobile());
                EExp.setText(user.getExperience());
                etMail.setText(user.getEmail());

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        {
                            fAuth = FirebaseAuth.getInstance();
                            fStore = FirebaseFirestore.getInstance();
//                            String userId = fAuth.getCurrentUser();
//                            String id = user.getID();

                            String Names = etName.getText().toString();
                            String Age = eAge.getText().toString();
                            String expe = etMail.getText().toString();
                            String Qua = EExp.getText().toString();
                            String Mail = emobile.getText().toString();
                            String  note= notes.getText().toString();



                            String userId = fAuth.getCurrentUser().getUid();

                            String id = fStore.collection("user").document(userId).collection("Jobs").document().getId();
                            DocumentReference df = fStore.collection("user").document(userId).collection("Jobs").document(id);

                            Map<String,Object> clients = new HashMap<>();
                            clients.put("Name",Names);
                            clients.put("Age",Age);
                            clients.put("Experience",expe);
                            clients.put("qualification",Qua);
                            clients.put("Email",Mail);
                            clients.put("Mobile",note);

                            df.set(clients).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(context.getApplicationContext(), "uploaded", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(context.getApplicationContext(),Adminlog.class);
//                                    String email = emobile.getText().toString();
                                    intent.putExtra("Email",Mail);
                                    context.startActivity(intent);
                                    ((Activity)context).finish();

                                }

                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });



                        }

                    }
                });
                d.dismiss();
                d.show();
            }
        });



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
