package com.example.lofginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    EditText mEmail,mpassword;
    Button mLoginbutton;
    TextView mCreateBtn;
    ProgressBar progressBar;
    boolean passwordVisible;

    SharedPreferences sharedPreferences;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mEmail = findViewById(R.id.mail);
        mpassword = findViewById(R.id.pwd);
        progressBar = findViewById(R.id.progressBar);
        mLoginbutton = findViewById(R.id.button);
        mCreateBtn = findViewById(R.id.createtxt);

        fAuth = FirebaseAuth.getInstance();

        mpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=mpassword.getRight()-mpassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=mpassword.getSelectionEnd();
                        if(passwordVisible){
                            mpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.pass,0);
                            mpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            mpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.showpassword,0);
                            mpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        mpassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),sign_in.class));
            }
        });

        mLoginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    mEmail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    mpassword.setError("Password is required");
                }

                if(password.length() < 8)
                {
                    mpassword.setError("Password must be >= 8 character");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Log In Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Dashboard.class));

                        }
                        else
                        {

                            Toast.makeText(getApplicationContext(), "Error" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });


    }
}