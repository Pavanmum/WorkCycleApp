package com.example.lofginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class eventupdatepage extends AppCompatActivity {
//    FloatingActionButton fab;
//    private RecyclerView eventsdep;
//    private LinearLayout evnodata;
//    private ArrayList<Event>list1;
//    private eventadapter adapter;
    DatabaseReference database;
    RecyclerView recyclerView;
    eventadapter adapter;
    ArrayList<Event> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventupdatepage);

//        eventsdep = findViewById(R.id.eventsdep);

//        evnodata = findViewById(R.id.evnodata);
        recyclerView = findViewById(R.id.recycler);

        database = FirebaseDatabase.getInstance().getReference("Event");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new eventadapter(list1,eventupdatepage.this);
        list = new ArrayList<>();
        adapter = new eventadapter(list,this);
        recyclerView.setAdapter(adapter);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                        Event data = snapshot1.getValue(Event.class);
                        list.add(data);
                    }
                    adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        fab = findViewById(R.id.fab);
//
//        fab.setOnClickListener(view -> {
//            startActivity(new Intent(eventupdatepage.this, Eventcreatepage.class));
//        });
    }
//
//    private void eventsdep() {
//        dbref = reference.child("Event");
//        dbref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list1 = new ArrayList<>();
////                if(!snapshot.exists()){
////                evnodata.setVisibility(View.GONE);
////                eventsdep.setVisibility(View.VISIBLE);
////                }else{
//                    for (DataSnapshot snapshot1 : snapshot.getChildren()){
//                        Event data = snapshot1.getValue(Event.class);
//                        list1.add(data);
//                    }
//                    addContentView();
//
////                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//               // Toast.makeText(eventupdatepage.this, DatabaseError.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}