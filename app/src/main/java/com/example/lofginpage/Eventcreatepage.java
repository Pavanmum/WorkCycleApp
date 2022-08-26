package com.example.lofginpage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lofginpage.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Eventcreatepage extends AppCompatActivity {

    private EditText dname, dwork, ddays,dlocation,dmoney,dperson;
    private Button dbtn,dbtnreset;

    FirebaseDatabase firebaseDatabase;


    DatabaseReference databaseReference;


    Event eventinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventcreatepage);

        dname = findViewById(R.id.Name);
        dwork = findViewById(R.id.Work);
        ddays = findViewById(R.id.days);
        dlocation = findViewById(R.id.location);
        dmoney = findViewById(R.id.money);
        dperson = findViewById(R.id.person);



        firebaseDatabase = FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getReference("Event");

        eventinfo = new Event();

        dbtn = findViewById(R.id.btn);
        dbtnreset = findViewById(R.id.btnreset);
        dbtnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dname.setText("");
                dwork.setText("");
                ddays.setText("");
                dlocation.setText("");
                dmoney.setText("");
                dperson.setText("");

            }
        });

        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String ename = dname.getText().toString();
                String ework = dwork.getText().toString();
                String eperson = dperson.getText().toString();
                String edays = ddays.getText().toString();
                String erupees = dmoney.getText().toString();
                String elocation = dlocation.getText().toString();


                if (TextUtils.isEmpty(ename) && TextUtils.isEmpty(ework) && TextUtils.isEmpty(eperson) && TextUtils.isEmpty(erupees)
               && TextUtils.isEmpty(elocation)&& TextUtils.isEmpty(edays) ) {

                    Toast.makeText(Eventcreatepage.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {

                    addDatatoFirebase(ename,ework,eperson,erupees,elocation,edays );
                }
            }
        });
    }

    private void addDatatoFirebase(String ename, String ework, String eperson,String edays, String elocation, String erupees) {
        eventinfo.setEname(ename);
        eventinfo.setEwork(ework);
        eventinfo.setEperson(eperson);
        eventinfo.setElocation(elocation);
        eventinfo.setErupees(erupees);
        eventinfo.setEdays(edays);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(eventinfo);

                Toast.makeText(Eventcreatepage.this, "Event created", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Eventcreatepage.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}