package com.example.lofginpage.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lofginpage.R;
import com.example.lofginpage.databinding.FragmentGalleryBinding;
import com.example.lofginpage.pedit;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class GalleryFragment extends Fragment {
    private FirebaseAuth mfirebaseAuth;


    Activity context;
    private Button edit;
    TextView first,email,name,contact,hEmail;
    private FragmentGalleryBinding binding;

    //    TextView tv;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId ;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mfirebaseAuth = FirebaseAuth.getInstance();
        context = getActivity();
        View root = inflater.inflate(R.layout.fragment_gallery,container,false);

        edit = root.findViewById(R.id.btn);
        first = root.findViewById(R.id.textView2);
        hEmail = root.findViewById(R.id.textView3);
        name = root.findViewById(R.id.textView4);
        email = root.findViewById(R.id.textView5);
        contact = root.findViewById(R.id.textView8);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        DocumentReference dr = fStore.collection("user").document(userId);
        dr.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                name.setText(value.getString("fName"));
                email.setText(value.getString("email"));
                contact.setText(value.getString("phone"));
//                hEmail.setText(value.getString(""));
                first.setText(value.getString("fName"));

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), pedit.class);
                startActivity(intent);

            }
        });


        return root;
    }
//    public void logout(View view){
//        mfirebaseAuth.signOut();
//    }
//
//    public void onStart(){
//        super.onStart();
//        TextView event = (TextView) context.findViewById(R.id.Eventcreate);
//        event.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, Eventcreatepage.class);
//                startActivity(intent);
//            }
//        });
//    }
}