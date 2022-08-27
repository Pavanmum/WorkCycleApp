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

import java.util.HashMap;
import java.util.Map;

public class Eventcreatepage extends AppCompatActivity {

//    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Event eventinfo;
    private EditText dname, dwork, ddays, dlocation, dmoney, dperson;
    private Button dbtn, dbtnreset;

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
                else {

                    HashMap<String, Object> m = new HashMap<String, Object>();
                    m.put("name", dname.getText().toString());
                    m.put("Work", dwork.getText().toString());
                    m.put("location", dlocation.getText().toString());
                    m.put("Money", dmoney.getText().toString());
                    m.put("Days", ddays.getText().toString());
                    m.put("Person", dperson.getText().toString());


                    FirebaseDatabase.getInstance().getReference().child("Event").push().setValue(m);
                    Toast.makeText(Eventcreatepage.this, "Created", Toast.LENGTH_SHORT).show();

                }
            }


        });
    }

    private void addDatatoFirebase(String ename, String ework, String eperson, String edays, String elocation, String erupees) {
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