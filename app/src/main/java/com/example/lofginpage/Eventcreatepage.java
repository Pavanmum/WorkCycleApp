package com.example.lofginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Eventcreatepage extends AppCompatActivity {
    private EditText meditTextTextPostalAddress2, meditTextNumberSigned2, meditTextNumber, meditTextNumberSigned, meditTextTextPostalAddress, meditTextTextPersonName;
    private Button mreset, msubmit;
//    private String name,people,work,days,money,location;
//    private ProgressDialog pd;
//    private DatabaseReference refrence;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventcreatepage);

        // refrence = FirebaseDatabase.getInstance().getReference();

        //   pd=new ProgressDialog(this);


        meditTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        meditTextTextPostalAddress = findViewById(R.id.editTextTextPostalAddress);
        mreset = findViewById(R.id.button4);
        meditTextNumber = findViewById(R.id.editTextNumber);
        meditTextNumberSigned = findViewById(R.id.editTextNumberSigned);
        meditTextNumberSigned2 = findViewById(R.id.editTextNumberSigned2);
        meditTextTextPostalAddress2 = findViewById(R.id.editTextTextPostalAddress2);

        // pd = new ProgressDialog(this);


        mreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meditTextNumber.setText("");
                meditTextNumberSigned.setText("");
                meditTextNumberSigned2.setText("");
                meditTextTextPostalAddress2.setText("");
                meditTextTextPostalAddress.setText("");
                meditTextTextPersonName.setText("");


            }
        });

//       // msubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkValidation();
//            }
//
//            private void checkValidation() {
//                name = meditTextTextPersonName.getText().toString();
//                people=meditTextTextPostalAddress.getText().toString();
//                work=meditTextNumberSigned.getText().toString();
//                days=meditTextNumber.getText().toString();
//                money=meditTextNumberSigned2.getText().toString();
//                location=meditTextTextPostalAddress2.getText().toString();
//
//                if(name.isEmpty()){
//                    meditTextTextPersonName.setError("Empty");
//                    meditTextTextPersonName.requestFocus();
//                }else if(people.isEmpty()){
//                    meditTextTextPostalAddress.setError("Empty");
//                    meditTextTextPostalAddress.requestFocus();
//                }else if(work.isEmpty()){
//                    meditTextNumberSigned.setError("Empty");
//                    meditTextNumberSigned.requestFocus();
//                }else if(days.isEmpty()){
//                    meditTextNumber.setError("Empty");
//                    meditTextTextPersonName.requestFocus();
//                }else if(money.isEmpty()){
//                    meditTextNumberSigned2.setError("Empty");
//                    meditTextNumberSigned2.requestFocus();
//                }else if(location.isEmpty()){
//                    meditTextTextPostalAddress2.setError("Empty");
//                    meditTextTextPostalAddress2.requestFocus();
//                }
        //uploadData();
        //      }

//            private void uploadData() {
//                pd.setMessage("Creating....");
//                pd.show();
//                refrence = refrence.child("Event");
//                final String uniquekey = refrence.push().getKey();
//                String  name = meditTextTextPersonName.getText().toString();
//                String people=meditTextTextPostalAddress.getText().toString();
//                String work=meditTextNumberSigned.getText().toString();
//                String days=meditTextNumber.getText().toString();
//                String money=meditTextNumberSigned2.getText().toString();
//                String location=meditTextTextPostalAddress2.getText().toString();
//
//
//
//                eventdata eventdata = new eventdata(name, people, work, days, money, location,uniquekey);
//
//                refrence.child(uniquekey).setValue(eventdata).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        pd.dismiss();
//                        Toast.makeText(Eventcreatepage.this, "Event Created", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        pd.dismiss();
//                        Toast.makeText(Eventcreatepage.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }


    }
    }

//}
