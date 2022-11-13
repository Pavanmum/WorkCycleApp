package com.example.WorkCycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class About_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        ImageView image1,image2,image3,image4;

        image1 = findViewById(R.id.imageView4);
        image2 = findViewById(R.id.imageView6);
        image3 = findViewById(R.id.imageView7);
        image4 = findViewById(R.id.imageView8);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://github.com/Pavanmum"));
                startActivity(viewIntent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.intent.action.VIEW",Uri.parse("https://www.linkedin.com/in/pavan-prasad-726a62246/"));
                startActivity(i);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic = new Intent("android.intent.action.VIEW",Uri.parse("https://youtube.com/channel/UCZZXnkLJfaqbbuHp9W7TzSw"));
                startActivity(ic);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent("android.intent.action.VIEW",Uri.parse("https://www.gurunanakcollegeasc.in/"));
                startActivity(c);
            }
        });


    }
}