package com.example.WorkCycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Eventcreatepage extends AppCompatActivity {


    Event eventinfo;
    private EditText dname, dwork, ddays, dlocation, dmoney, dperson;
    private Button dbtn, dbtnreset;
    DatabaseReference refrence;
    FirebaseDatabase db;


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


//        firebaseDatabase = FirebaseDatabase.getInstance();

//
////        databaseReference = firebaseDatabase.getReference("Event");
//        DatabaseReference.get

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

                if(ename.isEmpty()){
                    dname.setError("Enter a Event name");
                    dname.requestFocus();
                }
                else if(ework.isEmpty()){
                    dwork.setError("Enter a work");
                    dwork.requestFocus();
                }  else if(eperson.isEmpty()){
                    dperson.setError("Enter a number");
                    dname.requestFocus();
                }  else if(edays.isEmpty()){
                    ddays.setError("Enter a days");
                    ddays.requestFocus();
                }  else if(erupees.isEmpty()){
                    dmoney.setError("Enter a money");
                    dmoney.requestFocus();
                }  else if(elocation.isEmpty()){
                    dlocation.setError("location");
                    dlocation.requestFocus();
                }

                HashMap<String, Object> event = new HashMap<>();
                event.put("Name", ename);
                event.put("Work", ework);
                event.put("Person", eperson);
                event.put("Days", edays);
                event.put("Money", erupees);
                event.put("Location", elocation);


                db = FirebaseDatabase.getInstance();
                refrence = db.getReference("Event");
                refrence.child(ename).setValue(event);
                Toast.makeText(Eventcreatepage.this, "Created", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Adminlog.class));
            }




            private void addDatatoFirebase(String ename, String ework, String eperson, String edays, String elocation, String erupees) {
                eventinfo.setName(ename);
                eventinfo.setWork(ework);
                eventinfo.setPerson(eperson);
                eventinfo.setLocation(elocation);
                eventinfo.setMoney(erupees);
                eventinfo.setDays(edays);

            }
        });
    }
}