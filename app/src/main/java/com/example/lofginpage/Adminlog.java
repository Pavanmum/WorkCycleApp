package com.example.lofginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media.AudioAttributesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Adminlog extends AppCompatActivity {
    TextView btn;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlog);

        btn = findViewById(R.id.createEvent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Eventcreatepage.class));
            }
        });
    }
}