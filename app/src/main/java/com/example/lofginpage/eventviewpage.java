package com.example.lofginpage;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class eventviewpage extends AppCompatActivity {
    DatabaseReference database;
    RecyclerView recyclerView;
    eventadapter adapter;
    ArrayList<Event> list;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eventviewpage);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait.....");
        progressDialog.show();



        recyclerView = findViewById(R.id.userlist);

        database = FirebaseDatabase.getInstance().getReference("Event");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new eventadapter(list, this);
        recyclerView.setAdapter(adapter);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Event data = snapshot1.getValue(Event.class);
                    list.add(data);
                }
                adapter.notifyDataSetChanged();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent i = new Intent(getApplicationContext(),clientdata.class);
////                startActivity(i);
//            }
//        });
    }
}
