package com.example.WorkCycle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class clientdata extends AppCompatActivity {

    EditText  Name, age, qua,mail,phone,exp;
    MaterialButton Registerbtn;
    FirebaseFirestore db;
    ImageView backs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientdata);

        db = FirebaseFirestore.getInstance();
        Name = findViewById(R.id.Name);
        exp = findViewById(R.id.experience);
        age = findViewById(R.id.Age);
        qua = findViewById(R.id.qualification);
        Registerbtn = findViewById(R.id.btnRegister);
        mail = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        backs = findViewById(R.id.back);

        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(clientdata.this,cilentdash.class);
                startActivity(i);
                finish();
            }
        });


        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Names = Name.getText().toString();
                String Age = age.getText().toString();
                String expe = exp.getText().toString();
                String Qua = qua.getText().toString();
                String Mail = mail.getText().toString();
                String Phone = phone.getText().toString();
                if (TextUtils.isEmpty(Names)) {
                    Name.setError("Enter a Name");
                    return;
                }
                if (TextUtils.isEmpty(Age)) {
                    age.setError("Age is Required");
                    return;
                }

                if (TextUtils.isEmpty(expe)) {
                    exp.setError("Enter Experience");
                    return;
                }

                if (TextUtils.isEmpty(Qua)) {
                    qua.setError("Enter Qualification");
                    return;
                }
                if (TextUtils.isEmpty(Mail)) {
                    mail.setError("Enter Email");
                    return;
                }

                if (Phone.length() != 10) {
                    phone.setError("Enter valid no");
                    return;
                }
                Map<String,Object> clients = new HashMap<>();
                clients.put("Name",Names);
                clients.put("Age",Age);
                clients.put("Experience",expe);
                clients.put("qualification",Qua);
                clients.put("Email",Mail);
                clients.put("Mobile",Phone);

                db.collection("Client")
                        .add(clients)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(clientdata.this,"Successful",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {

                        Toast.makeText(clientdata.this,"Failed",Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });

    }
}