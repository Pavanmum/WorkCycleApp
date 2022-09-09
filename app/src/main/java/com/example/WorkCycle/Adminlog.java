package com.example.WorkCycle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Adminlog extends AppCompatActivity {
    TextView btn,btn1,btn2,btn3;
    ImageView t1;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlog);

        btn = findViewById(R.id.createEvent);
        btn1 =findViewById(R.id.deleteevent);
        btn2 = findViewById(R.id.updateevents);
        btn3 = findViewById(R.id.Eventcreate);
        t1 = findViewById(R.id.reverse);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Eventcreatepage.class));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), deletepage.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),UpdateData.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Adminlog.this,clientdetails.class));
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(i);
                finish();
            }
        });
    }
}