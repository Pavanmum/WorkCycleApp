package com.example.WorkCycle.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.WorkCycle.R;
import com.example.WorkCycle.databinding.FragmentHomeBinding;

public class activityFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View root =   inflater.inflate(R.layout.fragment_gallery, container, false);


        return root;
    }

}