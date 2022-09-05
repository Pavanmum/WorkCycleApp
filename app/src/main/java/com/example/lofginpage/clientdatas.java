

package com.example.lofginpage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lofginpage.ui.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class clientdatas extends AppCompatActivity {


    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    view adapter;
    ArrayList<User> lists;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lists = new ArrayList<>();
        adapter = new view(lists);
        recyclerView.setAdapter(adapter);

        fStore = FirebaseFirestore.getInstance();

        fStore.collection("Client").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> l = queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot ds : l) {
                    User user = ds.toObject(User.class);
                    lists.add(user);
                }
//                adapter.notifyDataSetChanged();
            }
        });
    }
}