package com.example.lofginpage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UpdateData extends AppCompatActivity {

    private EditText dname, dwork, ddays, dlocation, dmoney, dperson;
    private Button dbtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        dname = findViewById(R.id.Name);
        dwork = findViewById(R.id.Work);
        ddays = findViewById(R.id.days);
        dlocation = findViewById(R.id.location);
        dmoney = findViewById(R.id.money);
        dperson = findViewById(R.id.person);
        dbtn = findViewById(R.id.updatebtn);

        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ename = dname.getText().toString();
                String ework = dwork.getText().toString();
                String eperson = dperson.getText().toString();
                String edays = ddays.getText().toString();
                String erupees = dmoney.getText().toString();
                String elocation = dlocation.getText().toString();

                updatedata(ename,ework,eperson,edays,erupees,elocation);

            }

        });
    }

    private void updatedata(String ename, String ework, String eperson, String edays, String erupees, String elocation) {

        HashMap event = new HashMap();
        event.put("Work", ework);
        event.put("Person", eperson);
        event.put("Days", edays);
        event.put("Money", erupees);
        event.put("Location", elocation);
        databaseReference = FirebaseDatabase.getInstance().getReference("Event");
        databaseReference.child(ename).updateChildren(event).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

                if (task.isSuccessful()){

                    Toast.makeText(UpdateData.this,"Successfully Updated",Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(UpdateData.this,"Failed to Update",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


}