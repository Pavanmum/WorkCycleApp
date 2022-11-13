package com.example.WorkCycle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.WorkCycle.ui.gallery.GalleryFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class pedit extends AppCompatActivity {

    EditText etName,etPassword,etContact,etMail;
    Button button;
    FirebaseFirestore fStore;
    String userId;
    FirebaseAuth fAuth;
    String name,pass,mob,chEmail;
    ProgressBar progressBar;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedit);

//    ProfileUpdate profileUpdate =  getIntent().getSerializableExtra("profileUpdate");
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        etName = findViewById(R.id.updateName);
//        etPassword = findViewById(R.id.updatePass);
        etContact = findViewById(R.id.updateContact);
        etMail = findViewById(R.id.updateMail);

        DocumentReference dr = fStore.collection("user").document(userId);
        dr.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                etName.setText(value.getString("fName"));
                etMail.setText(value.getString("email"));
                etContact.setText(value.getString("phone"));
//                etPassword.setText(value.getString("Password"));

            }
        });



        button = findViewById(R.id.buttonUpdate);
        progressBar = findViewById(R.id.progressBar3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
//                pass = etPassword.getText().toString();
                mob = etContact.getText().toString();
                chEmail = etMail.getText().toString();

                if(TextUtils.isEmpty(name)){
                    etName.setError("Name is required");
                    return;

                }else if(TextUtils.isEmpty(mob)){
                    etContact.setError("Contact Number is required");
                    return;
                }
                else{
                    UpdateData(name,mob,chEmail);
                }
                Intent intent = new Intent(pedit.this, GalleryFragment.class);
                startActivity(intent);
                progressBar.setVisibility(View.VISIBLE);
                finish();

            }

            private void UpdateData(String name, String mob, String chEmail) {
                Map<String,Object> user = new HashMap<>();
                user.put("fName",name);
                user.put("email",chEmail);
                user.put("phone",mob);

                dr.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG,"onSuccess : User profile is created for "+userId);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG,"onFailure "+e.toString());
                    }
                });
            }
        });


    }
}