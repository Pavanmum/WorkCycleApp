package com.example.lofginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

public class sign_in extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText mFullname, mEmail, mPassword, mConfrimPassword, mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mFullname = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.pwd);
        mConfrimPassword = findViewById(R.id.Confirmpwd);
        mPhone = findViewById(R.id.Phone);
        mRegisterBtn = findViewById(R.id.btn1);
        mLoginBtn = findViewById(R.id.createtext);
        progressBar = findViewById(R.id.progressBar);


        FirebaseFirestore fstore;
        String userID;
        FirebaseAuth fAuth;


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            private FirebaseAuth fAuth;
            private FirebaseFirestore fstore;
            String userID;

            @Override
            public void onClick(View view) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String Confirmpassword = mConfrimPassword.getText().toString().trim();
                String fullname = mFullname.getText().toString().trim();
                String Phone = mPhone.getText().toString().trim();

                fAuth  = FirebaseAuth.getInstance();
                fstore = FirebaseFirestore.getInstance();



                if (TextUtils.isEmpty(fullname)) {
                    mFullname.setError("Enter a Name");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Enter a password");
                    return;
                }

                if (TextUtils.isEmpty(Confirmpassword)) {
                    mConfrimPassword.setError("Enter a password");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("password Must be maximum 8 Characters");
                    return;
                }

                if (Confirmpassword.length() < 6) {
                    mConfrimPassword.setError("password Must be maximum 8 Characters");
                    return;
                }

                if (Confirmpassword == password) {
                    mConfrimPassword.setError("Enter a Same Password");
                    return;
                }

                if (Phone.length() != 10) {
                    mPhone.setError("Enter valid no");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser fuser = fAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "register Successful", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "Onfailure: Email Not Sent" + e.getMessage());
                                }
                            });


                            Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("user").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fName", fullname);
                            user.put("email", email);
                            user.put("phone", Phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "onsucces: user profile is created for" + userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFaliure: " + e.toString());
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));


                        } else {
                            Toast.makeText(sign_in.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(view.GONE);
                        }
                    }
                });

            }
        });

    }

}






