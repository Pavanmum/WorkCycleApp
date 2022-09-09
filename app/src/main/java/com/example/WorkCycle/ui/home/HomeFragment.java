package com.example.WorkCycle.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.WorkCycle.Adminlog;
import com.example.WorkCycle.R;
import com.example.WorkCycle.SplashScreen;
import com.example.WorkCycle.cilentdash;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment {
    ViewFlipper view;
    Activity context;
    private FirebaseAuth mfirebaseAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mfirebaseAuth = FirebaseAuth.getInstance();
        context = getActivity();


        View root = inflater.inflate(R.layout.fragment_home, container, false);

        int imgarr[] = {R.drawable.facebook, R.drawable.google, R.drawable.twitter};
        view = root.findViewById(R.id.viewflipper);

        for (int i = 0; i < imgarr.length; i++) {
            showImage(imgarr[i]);
        }
        return root;

    }

    public void showImage(int img) {
        ImageView imageView = new ImageView(this.context);
        imageView.setBackgroundResource(img);

        view.addView(imageView);
        view.setFlipInterval(2000);
        view.setAutoStart(true);

        view.setInAnimation(context, android.R.anim.slide_in_left);
        view.setOutAnimation(context, android.R.anim.slide_out_right);


    }



    public void onStart() {
        super.onStart();
        TextView Admin = (TextView) context.findViewById(R.id.Admin);
        TextView Client = (TextView) context.findViewById(R.id.Client);
        TextView About = (TextView) context.findViewById(R.id.about);

        Client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, cilentdash.class);
                startActivity(intent);
            }
        });
        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Adminlog.class);
                startActivity(intent);

            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SplashScreen.class);
                startActivity(intent);

            }
        });


    }
}