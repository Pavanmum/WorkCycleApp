package com.example.lofginpage.ui.home;

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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lofginpage.Adminlog;
import com.example.lofginpage.Eventcreatepage;
import com.example.lofginpage.MainActivity;
import com.example.lofginpage.R;
import com.example.lofginpage.clientpage;
import com.example.lofginpage.databinding.FragmentHomeBinding;
import com.example.lofginpage.eventupdatepage;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;

import org.w3c.dom.Text;

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

    public void logout(View view) {
        mfirebaseAuth.signOut();
        Intent b = new Intent(getActivity(), MainActivity.class);
        startActivity(b);
    }

    public void onStart() {
        super.onStart();
        TextView Admin = (TextView) context.findViewById(R.id.Admin);
        TextView Client = (TextView) context.findViewById(R.id.Client);

        Client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,clientpage.class);
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


    }
}