package com.example.lofginpage.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lofginpage.Eventcreatepage;
import com.example.lofginpage.R;
import com.example.lofginpage.SplashScreen;
import com.example.lofginpage.databinding.FragmentGalleryBinding;
import com.example.lofginpage.sign_in;
import com.google.firebase.auth.FirebaseAuth;

public class GalleryFragment extends Fragment {
    private FirebaseAuth mfirebaseAuth;


    Activity context;


    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mfirebaseAuth = FirebaseAuth.getInstance();
        context = getActivity();
            View root = inflater.inflate(R.layout.fragment_gallery,container,false);

        return root;
    }
    public void logout(View view){
        mfirebaseAuth.signOut();
    }

    public void onStart(){
        super.onStart();
        TextView event = (TextView) context.findViewById(R.id.Eventcreate);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Eventcreatepage.class);
                startActivity(intent);
            }
        });
    }
}